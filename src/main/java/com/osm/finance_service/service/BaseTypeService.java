package com.osm.finance_service.service;


import com.osm.finance_service.model.BankAccount;
import com.osm.finance_service.model.BaseType;
import com.osm.finance_service.repo.BaseTypeRepository;
import com.xdev.communicator.models.common.dtos.BaseTypeDto;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class BaseTypeService {
    private final BaseTypeRepository typeRepository;
    private final ModelMapper modelMapper;
    public BaseTypeService(BaseTypeRepository typeRepository, ModelMapper modelMapper) {
        this.typeRepository = typeRepository;
        this.modelMapper = modelMapper;
    }

   public BaseType handelBaseType(BaseTypeDto dto) {
        if(dto==null) {return null;}
        if(dto.getExternalId()!=null) {
            BaseType exstingBaseType=typeRepository.findByExternalId(dto.getExternalId()).orElse(null);
            if(exstingBaseType!=null) {
                return exstingBaseType;
            }
        }
       BaseType  baseType=modelMapper.map(dto, BaseType.class);
       return typeRepository.save(baseType);
   }


}
