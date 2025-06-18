package com.osm.finance_service.service;


import com.osm.finance_service.dto.BankAccountDto;
import com.osm.finance_service.model.BankAccount;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class BankAccountService extends BaseServiceImpl<BankAccount, BankAccountDto, BankAccountDto> {

    public BankAccountService(BaseRepository<BankAccount> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }



}
