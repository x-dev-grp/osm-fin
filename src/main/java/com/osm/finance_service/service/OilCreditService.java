package com.osm.finance_service.service;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.ennum.CreditState;
import com.osm.finance_service.feignClients.services.OilTransactionFeignService;
import com.osm.finance_service.model.OilCredit;
import com.osm.finance_service.repo.OilCreditRepository;

import com.xdev.communicator.models.production.dto.OilTransactionDTO;
import com.xdev.communicator.models.production.enums.TransactionState;
import com.xdev.communicator.models.production.enums.TransactionType;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
public class OilCreditService extends BaseServiceImpl<OilCredit, OilCreditDto, OilCreditDto> {
   private final OilCreditRepository oilCreditRepository;
   private final OilTransactionFeignService oilTransactionFeignService;
    public OilCreditService(BaseRepository<OilCredit> repository, ModelMapper modelMapper, OilCreditRepository oilCreditRepository, OilTransactionFeignService oilTransactionFeignService) {
        super(repository, modelMapper);
        this.oilCreditRepository = oilCreditRepository;
        this.oilTransactionFeignService = oilTransactionFeignService;
    }

    @Override
    public OilCreditDto save(OilCreditDto request) {

        OilTransactionDTO oilTransaction = new OilTransactionDTO();
        oilTransaction.setTransactionState(TransactionState.PENDING);
        oilTransaction.setQuantityKg(request.getQuantity());
        oilTransaction.setTransactionType(TransactionType.LOAN);
        oilTransactionFeignService.create(oilTransaction).thenApply(response->{
            OilTransactionDTO  res=  response.getData();
            return res;
        });
//       todo use fiegn client
//  oilTransaction = oilTransactionRepository.save(oilTransaction);

        return  super.save(request);
    }
        public void approuveOilCredit(UUID transactionId) {
            OilCredit oilCredit = oilCreditRepository.findByTransactionIdOut(transactionId).orElse(null);
            if (Objects.nonNull(oilCredit)) {
                oilCredit.setCreditState(CreditState.APPLIED);
                oilCreditRepository.save(oilCredit);
            }
        }



}
