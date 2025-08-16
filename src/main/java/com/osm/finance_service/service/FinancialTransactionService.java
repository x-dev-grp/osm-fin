package com.osm.finance_service.service;

 import com.osm.finance_service.dto.FinancialTransactionDto;
 import com.xdev.communicator.models.shared.enums.Currency;
import com.xdev.communicator.models.shared.enums.TransactionDirection;
import com.xdev.communicator.models.shared.enums.TransactionType;
 import com.osm.finance_service.model.FinancialTransaction;
import com.osm.finance_service.repo.FinancialTransactionRepository;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class FinancialTransactionService extends BaseServiceImpl<FinancialTransaction, FinancialTransactionDto, FinancialTransactionDto> {
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.BASIC_ISO_DATE;

    private final FinancialTransactionRepository financialTransactionRepository;
    public FinancialTransactionService(BaseRepository<FinancialTransaction> repository, ModelMapper modelMapper, FinancialTransactionRepository financialTransactionRepository) {
        super(repository, modelMapper);
        this.financialTransactionRepository = financialTransactionRepository;
     }


    @Override
    @Transactional
    public FinancialTransactionDto save(FinancialTransactionDto request) {

        // --- 0) Ensure invoiceReference ---
        if (request.getInvoiceReference() == null || request.getInvoiceReference().isBlank()) {
            request.setInvoiceReference(generateNextInvoiceRef());
        }

        // --- 1) Map → entity & defaults ---
        FinancialTransaction tx = modelMapper.map(request, FinancialTransaction.class);


        if (tx.getTransactionDate() == null) {
            tx.setTransactionDate(LocalDateTime.now());
        }
        if (tx.getCurrency() == null) {
            tx.setCurrency(Currency.TND);
        }
        // infer direction if not set
        if (tx.getDirection() == null) {
            tx.setDirection(inferDirection(tx.getTransactionType()));
        }

        FinancialTransaction savedTx = financialTransactionRepository.save(tx);
        switch (savedTx.getTransactionType()) {

            // — Oil sales & purchases update their invoice balance —
            case OIL_SALE, OIL_PURCHASE -> {
                if (savedTx.getInvoiceReference() != null) {
                    updateOilInvoice(savedTx);
                }
            }

            // — Supplier payments/credits update supplier invoice balance —
            case SUPPLIER_PAYMENT, SUPPLIER_CREDIT -> {
                if (savedTx.getInvoiceReference() != null) {
                    updateSupplierInvoice(savedTx);
                }
            }

            // — Expense transactions mark the expense record paid —
            case EXPENSE -> {
                if (savedTx.getExpense() != null) {
                    markExpensePaid(savedTx);
                }
            }

            // — Other types (DEPOSIT, WITHDRAWAL, INTERNAL_TRANSFER, etc.) have no external side-effects —
            default -> {
                // no-op
            }
        }

        // --- 4) Map back → DTO & return ---
        return modelMapper.map(savedTx, FinancialTransactionDto.class);
    }

    private String generateNextInvoiceRef() {
        long count = financialTransactionRepository.count();
        String date = LocalDate.now().format(DATE_FMT);
        String seq = String.format("%06d", count + 1);
        return "INV-" + date + "-" + seq;
    }

    private TransactionDirection inferDirection(TransactionType type) {
        return switch (type) {
            case PAYMENT, SUPPLIER_PAYMENT, OIL_PURCHASE, WITHDRAWAL, CHECK_PAYMENT -> TransactionDirection.OUTBOUND;
            case CREDIT, SUPPLIER_CREDIT, OIL_SALE, DEPOSIT, CHECK_DEPOSIT -> TransactionDirection.INBOUND;
            case INTERNAL_TRANSFER -> TransactionDirection.INTERNAL;
            default -> TransactionDirection.INTERNAL;
        };
    }

    private void updateOilInvoice(FinancialTransaction tx) {

    }

    private void updateSupplierInvoice(FinancialTransaction tx) {

    }

    private void markExpensePaid(FinancialTransaction tx) {

    }


    @Override
    public Set<Action> actionsMapping(FinancialTransaction financialTransaction) {
        Set<Action> actions = new HashSet<>();
        actions.addAll(Set.of(Action.UPDATE, Action.DELETE, Action.READ));
        return actions;
    }


} 