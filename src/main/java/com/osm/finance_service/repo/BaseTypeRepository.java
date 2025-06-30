package com.osm.finance_service.repo;

import com.osm.finance_service.model.BaseType;
import com.xdev.xdevbase.repos.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BaseTypeRepository extends BaseRepository<BaseType> {
    Optional<BaseType> findByExternalId(UUID externalId);

}