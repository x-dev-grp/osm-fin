package com.osm.finance_service.service;


import com.osm.finance_service.dto.OilCreditDto;
import com.osm.finance_service.model.OilCredit;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class OilCreditService extends BaseServiceImpl<OilCredit, OilCreditDto, OilCreditDto> {

    public OilCreditService(BaseRepository<OilCredit> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }


}
