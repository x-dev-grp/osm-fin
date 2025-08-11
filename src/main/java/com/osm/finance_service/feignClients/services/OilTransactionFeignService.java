package com.osm.finance_service.feignClients.services;


import com.xdev.communicator.feignControllers.BaseFeignController;
import com.xdev.communicator.feignServices.BaseFeignService;
import com.xdev.communicator.models.shared.dto.OilTransactionDTO;
import org.springframework.stereotype.Service;

@Service
public class OilTransactionFeignService extends BaseFeignService<OilTransactionDTO,OilTransactionDTO> {
    public OilTransactionFeignService(BaseFeignController<OilTransactionDTO, OilTransactionDTO> baseFeignController) {
        super(baseFeignController);
    }
}
