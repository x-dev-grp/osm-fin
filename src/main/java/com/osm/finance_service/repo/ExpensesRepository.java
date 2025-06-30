package com.osm.finance_service.repo;

import com.osm.finance_service.model.Expense;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends BaseRepository<Expense> {
}