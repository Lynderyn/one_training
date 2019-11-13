package com.acme.acmetrade.endpoints;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TraderControllerTest {
	
	@Test
	void getTradersTest() {
		given()
		.accept(MediaType.APPLICATION_JSON_VALUE)
		.when()
		.get("/traders")
		.then()
		.statusCode(HttpStatus.OK.value());
	}
	
} // end of TraderControllerTest
