package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.MarketOrder;
import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.domain.TradersRankByTrades;
import com.acme.acmetrade.domain.TradersRankByVolume;
import com.acme.acmetrade.exception.TraderIdException;
import com.acme.acmetrade.exception.TraderNotFoundException;
import com.acme.acmetrade.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TradersService {

    private final TraderRepository traderRepository;

    @Autowired
    public TradersService(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public Iterable<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    public Trader getTrader(String traderId) {
        return traderRepository.findOneById(traderId);
    }

}
