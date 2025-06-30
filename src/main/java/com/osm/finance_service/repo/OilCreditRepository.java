package com.osm.finance_service.repo;

import com.osm.finance_service.model.OilCredit;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface OilCreditRepository extends BaseRepository<OilCredit> {
    @Query(
            value = "SELECT * FROM oil_credits oc WHERE oc.transaction_id_out = :txId",
            nativeQuery = true
    )
    Optional<OilCredit> findByTransactionIdOut(@Param("txId") UUID transactionIdOut);
}