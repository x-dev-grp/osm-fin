package com.osm.finance_service.service;

import com.osm.finance_service.dto.CustomerDto;
import com.osm.finance_service.model.Customer;
import com.osm.finance_service.model.OilSale;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
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
} 