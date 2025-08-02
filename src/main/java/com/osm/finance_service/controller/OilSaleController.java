package com.osm.finance_service.controller;

import com.osm.finance_service.dto.OilSaleDTO;
import com.osm.finance_service.model.OilSale;
import com.osm.finance_service.service.OilSaleService;
import com.xdev.xdevbase.apiDTOs.ApiResponse;
import com.xdev.xdevbase.apiDTOs.ApiSingleResponse;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.services.BaseService;
import com.xdev.xdevbase.utils.OSMLogger;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing oil sales
 */
@RestController
@RequestMapping("/api/finance/oil_sale")
public class OilSaleController extends BaseControllerImpl<OilSale, OilSaleDTO, OilSaleDTO> {

    private final OilSaleService oilSaleService;

    public OilSaleController(BaseService<OilSale, OilSaleDTO, OilSaleDTO> baseService,
                           ModelMapper modelMapper, OilSaleService oilSaleService) {
        super(baseService, modelMapper);
        this.oilSaleService = oilSaleService;
    }
    @Override
    protected String getResourceName() {
        return "OILSALE";
    }


}