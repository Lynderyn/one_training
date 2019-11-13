package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.services.TradersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("traders")
public class TraderController {


    @Autowired
    private TradersService tradersService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTrader(){
        return  new ResponseEntity<>(tradersService.getAllTraders(), HttpStatus.OK);

    }

}
