package com.osm.finance_service.service;

import com.osm.finance_service.dto.FinancialTransactionDto;
import com.osm.finance_service.model.FinancialTransaction;
import com.osm.finance_service.repo.FinancialTransactionRepository;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FinancialTransactionService extends BaseServiceImpl<FinancialTransaction, FinancialTransactionDto, FinancialTransactionDto> {

    private final FinancialTransactionRepository financialTransactionRepository;

    public FinancialTransactionService(BaseRepository<FinancialTransaction> repository, ModelMapper modelMapper, FinancialTransactionRepository financialTransactionRepository) {
        super(repository, modelMapper);
        this.financialTransactionRepository = financialTransactionRepository;
    }

    @Override
    public Set<Action> actionsMapping(FinancialTransaction financialTransaction) {
        Set<Action> actions = new HashSet<>();
        actions.addAll(Set.of(Action.UPDATE, Action.DELETE, Action.READ));
        return actions;
    }


} 