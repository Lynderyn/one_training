package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.exception.TraderIdException;
import com.acme.acmetrade.exception.TraderNotFoundException;
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
		Trader myTrader = tradersService.getTrader(id);
		if(myTrader == null) {
			throw new TraderNotFoundException("The trader with id '" + id + "' was not found.");
		}
		return new ResponseEntity<>(myTrader, HttpStatus.FOUND);
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
		return new ResponseEntity<Object>("Successfully deleted trader", HttpStatus.OK);
	}

	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateTrader(@PathVariable(name = "id") String traderId,
											   @Valid @RequestBody Trader trader, BindingResult bindingResult) {
		mapValidationErrorService.MapValidationService(bindingResult);
		if(trader.getId() == null || trader.getId().isEmpty()) {
			trader.setId(traderId);
		}
		if(!traderId.equals(trader.getId())) {
			String badId = trader.getId();
			throw new TraderIdException("Attempting to update traders with mismatched ids.  id 1 = '" + badId + "' and id 2 = '" + traderId +"'");
		}
		Trader updatedTrader = tradersService.updateTrader(trader);
		return new ResponseEntity<>(updatedTrader, HttpStatus.OK);
	}

}
