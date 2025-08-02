package com.osm.finance_service.controller;

import com.osm.finance_service.dto.CustomerDto;
import com.osm.finance_service.model.Customer;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/customers")
 public class CustomerController extends BaseControllerImpl<Customer, CustomerDto, CustomerDto> {

    public CustomerController(BaseService<Customer, CustomerDto, CustomerDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }

    @Override
    protected String getResourceName() {
        return "CUSTOMER";
    }
} 