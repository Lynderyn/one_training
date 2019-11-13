package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.StockQuote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StockQuoteRepository extends CrudRepository<StockQuote, String> {
    Iterable<StockQuote> findAllByTickerContaining(String tickerSymbol);

    @Query(value = "SELECT * FROM stock_quote sq WHERE sq.ticker = ?1 AND sq.quote_time > ?2 AND sq.quote_time < ?3 ORDER BY sq.quote_time desc"
            , nativeQuery = true)
    Iterable<StockQuote> findAllByTickerContainingAndOrderByQuoteTimeDesc(String tickerSymbol, Date from, Date to);

    @Query(value = "SELECT * FROM stock_quote sq WHERE sq.ticker = ?1 AND sq.quote_time > ?2 AND sq.quote_time < ?3 ORDER BY sq.quote_time asc"
            , nativeQuery = true)
    Iterable<StockQuote> findAllByTickerContainingAndOrderByQuoteTimeAsc(String tickerSymbol, Date from, Date to);

    Iterable<StockQuote> findAllByTicker(String ticker);

}
