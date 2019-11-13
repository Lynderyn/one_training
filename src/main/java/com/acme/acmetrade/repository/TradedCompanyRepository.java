package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.TradedCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradedCompanyRepository extends CrudRepository<TradedCompany, String> {

    Iterable<TradedCompany> findAllByCompanyNameStartsWith(String partialName);
    Iterable<TradedCompany> findAllByTickerStartsWith(String partialTicker);
    Iterable<TradedCompany> findAllByCompanyNameStartsWithAndTickerStartsWith(String partialName, String partialTicker);
    TradedCompany findFirstBySectorNameEquals(String sectorName);
}
