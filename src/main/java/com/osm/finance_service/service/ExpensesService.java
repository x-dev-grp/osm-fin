package com.osm.finance_service.service;


import com.osm.finance_service.dto.ExpenseDto;
import com.osm.finance_service.model.Expense;
import com.xdev.xdevbase.repos.BaseRepository;
import com.xdev.xdevbase.services.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ExpensesService extends BaseServiceImpl<Expense, ExpenseDto, ExpenseDto> {

    public ExpensesService(BaseRepository<Expense> repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }


}
