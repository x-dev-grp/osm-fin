package com.osm.finance_service.controller;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.model.OilCredit;
 import com.xdev.xdevbase.controllers.impl.BaseControllerImpl;
import com.xdev.xdevbase.models.OSMModule;
import com.xdev.xdevbase.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance/oil-credit")
@CrossOrigin
public class OilCreditController extends BaseControllerImpl<OilCredit, OilCreditDto, OilCreditDto>
 {


    public OilCreditController(BaseService<OilCredit, OilCreditDto, OilCreditDto> baseService, ModelMapper modelMapper) {
        super(baseService, modelMapper);
    }
     @Override
     protected String getResourceName() {
         return "OilCredit".toUpperCase();
     }

}
