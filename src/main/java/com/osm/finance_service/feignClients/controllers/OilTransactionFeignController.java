package com.osm.finance_service.feignClients.controllers;

import com.xdev.communicator.feignControllers.BaseFeignController;
import com.xdev.communicator.models.production.dto.OilTransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "oilproductionservice", path = "/api/production/oil_transaction")
public interface OilTransactionFeignController extends BaseFeignController<OilTransactionDTO,OilTransactionDTO> {
}
