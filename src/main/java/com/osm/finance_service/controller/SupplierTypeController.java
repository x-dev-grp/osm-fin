package com.osm.finance_service.controller;


import com.osm.finance_service.dto.SupplierDto;
import com.osm.finance_service.model.Supplier;
import com.osm.finance_service.service.SupplierTypeService;
import com.xdev.xdevbase.apiDTOs.ApiSingleResponse;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/suppliers_type")
public class SupplierTypeController extends BaseControllerImpl<Supplier, SupplierDto, SupplierDto> {

    private final SupplierTypeService supplierTypeService;

    public SupplierTypeController(BaseService<Supplier, SupplierDto, SupplierDto> baseService, ModelMapper modelMapper, SupplierTypeService supplierTypeService) {
        super(baseService, modelMapper);
        this.supplierTypeService = supplierTypeService;
    }


    @Override
    protected String getResourceName() {
        return "Supplier".toUpperCase();
    }
}
