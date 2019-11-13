package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
