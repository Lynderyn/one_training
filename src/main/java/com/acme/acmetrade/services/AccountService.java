package com.acme.acmetrade.services;

import com.acme.acmetrade.domain.Account;
import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.exception.AccountIdException;
import com.acme.acmetrade.exception.AccountNotFoundException;
import com.acme.acmetrade.exception.TraderIdException;
import com.acme.acmetrade.exception.TraderNotFoundException;
import com.acme.acmetrade.repository.AccountRepository;
import com.acme.acmetrade.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TradersService tradersService;

    @Autowired
    public AccountService(AccountRepository accountRepository, @Lazy TradersService tradersService) {
        this.accountRepository = accountRepository;
        this.tradersService = tradersService;
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(String accountId) {
        return accountRepository.findOneById(accountId);
    }

    public Account createAccount(Account account) {
        String id = account.getId();
        if(id != null && !id.isEmpty()) {
            if(accountRepository.existsById(id)) {
                throw new AccountIdException("The account id of '" + id + "' already exists");
            }
        }
        Trader trader = tradersService.getTrader(account.getTrader().getId());
        if(trader == null) {
            throw new TraderNotFoundException("Attempting to create an account for a trader with an id of '" + account.getTrader().getId() + "' that does not exist");
        }
        account.setTrader(trader);
        Account newAcct = accountRepository.save(account);
        trader.addAccount(newAcct);
        tradersService.updateTrader(trader);
        return newAcct;
    }

    public void deleteAccount(String accountId) {
        if(!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException("The account with id '" + accountId + "' does not exist.");
        }
        accountRepository.deleteById(accountId);
    }
}
