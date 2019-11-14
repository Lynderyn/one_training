package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Account;
import com.acme.acmetrade.exception.AccountNotFoundException;
import com.acme.acmetrade.services.AccountService;
import com.acme.acmetrade.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "accounts")
public class AccountController {

    private final AccountService accountService;
    private final MapValidationErrorService mapValidationErrorService;

    @Autowired
    public AccountController(AccountService accountService, MapValidationErrorService mapValidationErrorService) {
        this.accountService = accountService;
        this.mapValidationErrorService = mapValidationErrorService;
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

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAccount(@Valid @RequestBody Account myAccount, BindingResult bindingResult) {
        mapValidationErrorService.MapValidationService(bindingResult);
        Account newAccount = accountService.createAccount(myAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAccount(@PathVariable(name = "id") String accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("The account with id '" + accountId + "' was deleted.", HttpStatus.OK);
    }
}
