package com.osm.finance_service.controller;

import com.osm.finance_service.dto.FinancialTransactionDto;
import com.osm.finance_service.model.FinancialTransaction;
import com.osm.finance_service.service.FinancialTransactionService;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/transactions")
public class FinancialTransactionController extends BaseControllerImpl<FinancialTransaction, FinancialTransactionDto, FinancialTransactionDto> {

    private final FinancialTransactionService financialTransactionService;

    public FinancialTransactionController(BaseService<FinancialTransaction, FinancialTransactionDto, FinancialTransactionDto> baseService, ModelMapper modelMapper, FinancialTransactionService financialTransactionService) {
        super(baseService, modelMapper);
        this.financialTransactionService = financialTransactionService;
    }

    @Override
    protected String getResourceName() {
        return "FinancialTransaction".toUpperCase();
    }

} 