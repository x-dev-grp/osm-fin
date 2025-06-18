package com.osm.finance_service.controller;


import com.osm.finance_service.dto.BankAccountDto;
import com.osm.finance_service.model.BankAccount;
 import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.models.OSMModule;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/banks")
@CrossOrigin
public class BankAccountController extends BaseControllerImpl<BankAccount, BankAccountDto, BankAccountDto> {


    public BankAccountController(BaseService<BankAccount, BankAccountDto, BankAccountDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }

    @Override
    protected String getResourceName() {
        return "BankAccount".toUpperCase();
    }


}
