package com.osm.finance_service.repo;

import com.osm.finance_service.ennum.SaleStatus;
import com.osm.finance_service.model.OilSale;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OilSaleRepository extends BaseRepository<OilSale> {

} 