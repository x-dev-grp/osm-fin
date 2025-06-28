package com.osm.finance_service.service;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.ennum.CreditState;
import com.osm.finance_service.model.OilCredit;
import com.osm.finance_service.repo.OilCreditRepository;
import com.xdev.models.production.dto.OilTransactionDTO;
import com.xdev.models.production.enums.TransactionState;
import com.xdev.models.production.enums.TransactionType;
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
    public OilCreditService(BaseRepository<OilCredit> repository, ModelMapper modelMapper, OilCreditRepository oilCreditRepository) {
        super(repository, modelMapper);
        this.oilCreditRepository = oilCreditRepository;
    }

    @Override
    public OilCreditDto save(OilCreditDto request) {

         OilTransactionDTO oilTransaction = new OilTransactionDTO();
        oilTransaction.setTransactionState(TransactionState.PENDING);
        oilTransaction.setQuantityKg(request.getQuantity());
        oilTransaction.setTransactionType(TransactionType.LOAN);
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
