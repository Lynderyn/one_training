package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Account;
import com.acme.acmetrade.exception.AccountNotFoundException;
import com.acme.acmetrade.repository.AccountRepository;
import com.acme.acmetrade.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAccountById(@PathVariable(name = "id") String accountId) {
        Account myAccount = accountService.getAccount(accountId);
        if(myAccount == null) {
            throw new AccountNotFoundException("The account with account id '" + accountId + "' was not found");
        }
        return new ResponseEntity<>(myAccount, HttpStatus.FOUND);
    }
}
