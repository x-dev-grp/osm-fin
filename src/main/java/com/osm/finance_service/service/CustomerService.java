package com.osm.finance_service.service;

import com.osm.finance_service.dto.CustomerDto;
import com.osm.finance_service.model.Customer;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import com.xdev.xdevbase.utils.OSMLogger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerService extends BaseServiceImpl<Customer, CustomerDto, CustomerDto> {

    public CustomerService(BaseRepository<Customer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }
    @Override
    public Set<Action> actionsMapping(Customer Customer) {
        Set<Action> actions = new HashSet<>();
        actions.addAll(Set.of(Action.UPDATE, Action.DELETE, Action.READ));
        return actions;
    }
    public Customer handelCustomer(CustomerDto dto) {

        try {
            if(dto==null) {
                OSMLogger.logDataAccess(this.getClass(), "CUSTOMER_HANDLE", "Customer");
                return null;
            }

            if(dto.getExternalId()!=null) {
                OSMLogger.logDataAccess(this.getClass(), "CUSTOMER_LOOKUP", "Customer");

                Customer exstingCustomer=repository.findByExternalIdAndIsDeletedFalse(dto.getExternalId()).orElse(null);
                if(exstingCustomer!=null) {
                    OSMLogger.logDataAccess(this.getClass(), "CUSTOMER_FOUND", "Customer");
                    return exstingCustomer;
                } else {
                    OSMLogger.logDataAccess(this.getClass(), "CUSTOMER_NOT_FOUND", "Customer");
                }
            }

            Customer Customer=modelMapper.map(dto, Customer.class);
            Customer.setId(null);
            Customer savedCustomer = repository.save(Customer);
            OSMLogger.logMethodExit(this.getClass(), "handelCustomer", savedCustomer);

            return savedCustomer;

        } catch (Exception e) {
            OSMLogger.logException(this.getClass(), "Error handling Customer", e);
            throw e;
        }
    }
} 