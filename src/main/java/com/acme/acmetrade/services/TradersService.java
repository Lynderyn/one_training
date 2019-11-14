package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.exception.TraderIdException;
import com.acme.acmetrade.exception.TraderNotFoundException;
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
    
    public void deleteTrader(String traderId) {
    	traderRepository.deleteById(traderId);
    }

    public Trader createTrader(Trader trader) {
        String id = trader.getId();
        if(id != null && !id.isEmpty()) {
            if(traderRepository.existsById(id)) {
                throw new TraderIdException("The Trader ID '" + id + "' already exists");
            }
        }
        return traderRepository.save(trader);
    }

    public Trader updateTrader(Trader trader) {
        if(!traderRepository.existsById(trader.getId())) {
            throw new TraderNotFoundException("The trader with id '" + trader.getId() + "' was not found");
        }
        return traderRepository.save(trader);
    }
}
