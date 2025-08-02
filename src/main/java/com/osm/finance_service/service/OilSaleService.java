package com.osm.finance_service.service;


import com.osm.finance_service.dto.OilSaleDTO;
import com.osm.finance_service.model.Expense;
import com.osm.finance_service.model.OilSale;
import com.osm.finance_service.repo.CustomerRepository;
import com.osm.finance_service.repo.OilSaleRepository;
import com.xdev.xdevbase.models.Action;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import com.xdev.xdevbase.utils.OSMLogger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Service class for managing oil sales operations
 */
@Service
public class OilSaleService extends BaseServiceImpl<OilSale, OilSaleDTO, OilSaleDTO> {

    private final OilSaleRepository oilSaleRepository;
    private final CustomerRepository customerRepository;

    public OilSaleService(OilSaleRepository repository, ModelMapper modelMapper, 
                         CustomerRepository customerRepository ) {
        super(repository, modelMapper);
        this.oilSaleRepository = repository;
        this.customerRepository = customerRepository;
;
    }

    @Override
    public Set<Action> actionsMapping(OilSale oilSale) {
        Set<Action> actions = new HashSet<>();
        actions.addAll(Set.of(Action.UPDATE, Action.DELETE, Action.READ));
        return actions;
    }

} 