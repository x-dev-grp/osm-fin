package com.osm.finance_service.service;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.ennum.CreditState;
import com.osm.finance_service.feignClients.services.OilTransactionFeignService;
import com.osm.finance_service.model.OilCredit;
import com.osm.finance_service.repo.OilCreditRepository;

import com.xdev.communicator.models.common.dtos.apiDTOs.ApiSingleResponse;
import com.xdev.communicator.models.production.dto.OilTransactionDTO;
import com.xdev.communicator.models.production.enums.TransactionState;
import com.xdev.communicator.models.production.enums.TransactionType;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class OilCreditService extends BaseServiceImpl<OilCredit, OilCreditDto, OilCreditDto> {
   private static final Logger log = LoggerFactory.getLogger(OilCreditService.class);
   
   private final OilCreditRepository oilCreditRepository;
   private final OilTransactionFeignService oilTransactionFeignService;
   
    public OilCreditService(BaseRepository<OilCredit> repository, ModelMapper modelMapper, OilCreditRepository oilCreditRepository, OilTransactionFeignService oilTransactionFeignService) {
        super(repository, modelMapper);
        this.oilCreditRepository = oilCreditRepository;
        this.oilTransactionFeignService = oilTransactionFeignService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OilCreditDto save(OilCreditDto request) {
        // 1) Build your transaction DTO
        OilTransactionDTO oilTransaction = new OilTransactionDTO();
        oilTransaction.setTransactionState(TransactionState.PENDING);
        oilTransaction.setQuantityKg(request.getQuantity());
        oilTransaction.setTransactionType(TransactionType.LOAN);
        oilTransaction.setTotalPrice(0.0);
        oilTransaction.setUnitPrice(0.0);

        // 2) Invoke Feign synchronously and get the response
        ApiSingleResponse<OilTransactionDTO> response;
        try {
            response = oilTransactionFeignService
                    .create(oilTransaction)
                    .get();  // blocks until the remote call completes
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error calling oilTransactionFeignService.create()", e);
            throw new RuntimeException("Failed to create oil transaction", e);
        }

        // 3) Check for success and extract the ID
        if (response == null || !response.isSuccess() || response.getData() == null) {
            log.error("Oil transaction creation failed: {}", response);
            throw new RuntimeException("Failed to create oil transaction");
        }
        UUID createdId = response.getData().getId();
        log.info("Successfully created oil transaction with ID: {}", createdId);

        // 4) Only now set the transaction ID and save the credit
        request.setTransaction_id_out(createdId);
        OilCreditDto savedCredit = super.save(request);
        log.info("Saved oil credit with ID: {} and transaction ID: {}",
                savedCredit.getId(), createdId);

        return savedCredit;
    }


    public void approuveOilCredit(UUID transactionId) {
        OilCredit oilCredit = oilCreditRepository.findByTransactionIdOut(transactionId).orElse(null);
        if (Objects.nonNull(oilCredit)) {
            oilCredit.setCreditState(CreditState.APPLIED);
            oilCreditRepository.save(oilCredit);
            log.info("Approved oil credit for transaction ID: {}", transactionId);
        } else {
            log.warn("No oil credit found for transaction ID: {}", transactionId);
        }
    }

}
