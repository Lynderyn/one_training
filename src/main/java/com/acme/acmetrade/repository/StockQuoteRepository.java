package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.StockQuote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StockQuoteRepository extends CrudRepository<StockQuote, String> {
    Iterable<StockQuote> findAllByTickerContaining(String tickerSymbol);
    Iterable<StockQuote> findAllByTicker(String ticker);

}
