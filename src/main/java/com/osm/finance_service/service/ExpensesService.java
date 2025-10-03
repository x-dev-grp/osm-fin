package com.osm.finance_service.service;


import com.osm.finance_service.dto.ExpenseDto;
import com.osm.finance_service.dto.FinancialTransactionDto;
import com.osm.finance_service.model.Expense;
import com.osm.finance_service.model.FinancialTransaction;
import com.osm.finance_service.repo.FinancialTransactionRepository;
import com.xdev.communicator.models.enums.Currency;
import com.xdev.communicator.models.enums.TransactionDirection;
import com.xdev.communicator.models.enums.TransactionType;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Service
public class ExpensesService extends BaseServiceImpl<Expense, ExpenseDto, ExpenseDto> {
    private final FinancialTransactionRepository financialTransactionRepository;

    public ExpensesService(BaseRepository<Expense> repository, ModelMapper modelMapper, FinancialTransactionRepository financialTransactionRepository) {
        super(repository, modelMapper);
        this.financialTransactionRepository = financialTransactionRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExpenseDto save(ExpenseDto request) {
        Expense expense = modelMapper.map(request, Expense.class);
        Expense savdExpense = repository.save(expense);
        FinancialTransactionDto financialTransactionDto = new FinancialTransactionDto();
        financialTransactionDto.setTransactionType(TransactionType.EXPENSE);
        financialTransactionDto.setDirection(TransactionDirection.OUTBOUND);
        financialTransactionDto.setAmount(BigDecimal.valueOf(savdExpense.getAmount()));
        financialTransactionDto.setCurrency(Currency.TND);
        financialTransactionDto.setExpense(modelMapper.map(savdExpense, ExpenseDto.class));
        financialTransactionDto.setCheckNumber(savdExpense.getCheckNumber() != null ? savdExpense.getCheckNumber() : null);
        financialTransactionDto.setTransactionDate(LocalDateTime.now());
        financialTransactionDto.setApproved(true);
        financialTransactionDto.setApprovalDate(LocalDateTime.now());
        FinancialTransaction financialTransaction = modelMapper.map(financialTransactionDto, FinancialTransaction.class);
        financialTransactionRepository.save(financialTransaction);
        return modelMapper.map(savdExpense, ExpenseDto.class);
    }

    @Override
    public Set<Action> actionsMapping(Expense expense) {
        Set<Action> actions = new HashSet<>();
        actions.addAll(Set.of(Action.UPDATE, Action.DELETE, Action.READ));
        return actions;
    }
}
