package com.osm.finance_service.service;


import com.osm.finance_service.model.BaseType;
import com.osm.finance_service.repo.BaseTypeRepository;
import com.xdev.communicator.models.common.dtos.BaseTypeDto;
import com.xdev.xdevbase.utils.OSMLogger;
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
        long startTime = System.currentTimeMillis();
        OSMLogger.logMethodEntry(this.getClass(), "handelBaseType", dto);
        
        try {
            if(dto==null) {
                OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_HANDLE", "BaseType");
                return null;
            }
            
            if(dto.getExternalId()!=null) {
                OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_LOOKUP", "BaseType");
                
                BaseType exstingBaseType=typeRepository.findByExternalId(dto.getExternalId()).orElse(null);
                if(exstingBaseType!=null) {
                    OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_FOUND", "BaseType");
                    OSMLogger.logMethodExit(this.getClass(), "handelBaseType", exstingBaseType);
                    OSMLogger.logPerformance(this.getClass(), "handelBaseType", startTime, System.currentTimeMillis());
                    return exstingBaseType;
                } else {
                    OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_NOT_FOUND", "BaseType");
                }
            }
            
            OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_CREATE", "BaseType");
            
            BaseType baseType=modelMapper.map(dto, BaseType.class);
            baseType.setId(null);
            BaseType savedBaseType = typeRepository.save(baseType);
            
            OSMLogger.logDataAccess(this.getClass(), "BASE_TYPE_SAVED", "BaseType");
            OSMLogger.logBusinessEvent(this.getClass(), "BASE_TYPE_CREATED", 
                "Created new BaseType: " + savedBaseType.getName() + " (ID: " + savedBaseType.getId() + ")");
            
            OSMLogger.logMethodExit(this.getClass(), "handelBaseType", savedBaseType);
            OSMLogger.logPerformance(this.getClass(), "handelBaseType", startTime, System.currentTimeMillis());
            
            return savedBaseType;
            
        } catch (Exception e) {
            OSMLogger.logException(this.getClass(), "Error handling BaseType", e);
            throw e;
        }
   }
}
