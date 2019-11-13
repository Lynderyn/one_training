package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Trader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TraderControllerTest {
	
	@Test
	void getTradersTest() {
		given()
		.accept(MediaType.APPLICATION_JSON_VALUE)
		.when()
		.get("/traders/")
		.then()
		.statusCode(HttpStatus.OK.value());
	}

	@Test
	void getTraderIdTest(){
		Trader rtnValue =
		given()
		.accept(MediaType.APPLICATION_JSON_VALUE)
		.when()
		.get("/trader/id")
		.then()
		.statusCode(HttpStatus.OK.value())
		.and()
		.extract().as(Trader.class);

		assertNotNull(rtnValue);


	}
	
} // end of TraderControllerTest
