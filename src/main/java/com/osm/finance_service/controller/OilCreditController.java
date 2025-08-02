package com.osm.finance_service.controller;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.model.OilCredit;
import com.osm.finance_service.service.OilCreditService;
import com.xdev.xdevbase.apiDTOs.ApiResponse;
import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.models.OSMModule;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/finance/oil-credit")

public class OilCreditController extends BaseControllerImpl<OilCredit, OilCreditDto, OilCreditDto>
 {
    private final OilCreditService oilCreditService;

    public OilCreditController(BaseService<OilCredit, OilCreditDto, OilCreditDto> baseService, ModelMapper modelMapper, OilCreditService oilCreditService) {
        super(baseService, modelMapper);
        this.oilCreditService = oilCreditService;
    }

     @PutMapping("/{transactionId}/approve")
     public ResponseEntity<Void> approveOilCredit(@PathVariable UUID transactionId) {
        try {
            oilCreditService.approuveOilCredit(transactionId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
             return ResponseEntity.notFound().build();
        }

     }


     @Override
     protected String getResourceName() {
         return "OILCREDIT";
     }

}
