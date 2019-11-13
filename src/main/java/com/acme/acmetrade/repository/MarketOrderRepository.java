package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.MarketOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketOrderRepository extends CrudRepository<MarketOrder, String> {
    MarketOrder findFirstByTickerEquals(String ticker);
    MarketOrder findFirstByTraderIdEquals(String traderId);
    Iterable<MarketOrder> findAllByTraderId(String traderId);
    MarketOrder findFirstByTraderIdOrderByCreatedAtDesc(String traderId);
}
