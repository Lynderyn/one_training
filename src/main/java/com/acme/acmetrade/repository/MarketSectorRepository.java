package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.MarketSector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketSectorRepository extends CrudRepository<MarketSector, String> {

    public MarketSector findByNameEquals(String name);
}
