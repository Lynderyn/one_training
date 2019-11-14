package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.repository.TraderRepository;
import io.restassured.mapper.TypeRef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class AccountControllerTest {

	@Autowired
	private TraderRepository traderRepository;

	@Autowired
	private TraderController traderController;

	private Trader testTrader;

	@BeforeEach
	void initTrader() {
		Trader myTrader = new Trader();
		myTrader.setfName("first");
		myTrader.setlName("last");
		myTrader.setAddress("1 test");
		myTrader.setEmail("test@test.com");
		myTrader.setPhone("555-555-5555");
		testTrader = traderRepository.save(myTrader);
	}

	@AfterEach
	void killTrader() {
		if(traderRepository.existsById(testTrader.getId())) {
			traderRepository.delete(testTrader);
		}
	}

	

	//adam methods below

    //adam methods above

    //hoa methods below

    //hoa methods above

    //mz meth below
	
    //mz method above

    //jesse methods below

	@Test
	void addSamePersonTwice() {
		given().request().body(testTrader).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
		.when().post("/traders/")
		.then().statusCode(HttpStatus.BAD_REQUEST.value());
	}

    //my methods above

} // end of TraderControllerTest
