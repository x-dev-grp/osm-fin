package com.osm.finance_service.controller;


import com.osm.finance_service.dto.ExpenseDto;
import com.osm.finance_service.model.Expense;
 import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.models.OSMModule;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/expense")

public class ExpensesController extends BaseControllerImpl<Expense, ExpenseDto, ExpenseDto>  {


    public ExpensesController(BaseService<Expense, ExpenseDto, ExpenseDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }

    @Override
    protected String getResourceName() {
        return "Expense".toUpperCase();
    }
}
