package com.acme.acmetrade.endpoints;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trader")
public class TraderController {

    @GetMapping(path = "Traders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTrader(){
        return  new ResponseEntity<>(new Trader("Account"))
    }

}
