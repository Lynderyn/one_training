package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.services.MapValidationErrorService;
import com.acme.acmetrade.services.TradersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("traders")
public class TraderController {

	private final TradersService tradersService;
	private final MapValidationErrorService mapValidationErrorService;

	@Autowired
	public TraderController(TradersService tradersService, MapValidationErrorService mapValidationErrorService) {
		this.tradersService = tradersService;
		this.mapValidationErrorService = mapValidationErrorService;
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getTrader() {
		return new ResponseEntity<>(tradersService.getAllTraders(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getTraderById(@PathVariable("id") String id) {
		return new ResponseEntity<Object>(tradersService.getTrader(id), HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createTrader(@Valid @RequestBody Trader trader, BindingResult bindingResult) {
		mapValidationErrorService.MapValidationService(bindingResult);
		Trader createdTrader = tradersService.createTrader(trader);
		return new ResponseEntity<>(createdTrader, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteTraderById(@PathVariable("id") String id) {
		tradersService.deleteTrader(id);
		return new ResponseEntity<Object>("Sucessfully deleted trader", HttpStatus.OK);
	}

}
