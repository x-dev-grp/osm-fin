package com.osm.finance_service.repo;

import com.osm.finance_service.model.FinancialTransaction;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepository extends BaseRepository<FinancialTransaction> {

} 