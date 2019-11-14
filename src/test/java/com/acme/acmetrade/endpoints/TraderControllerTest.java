package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.repository.TraderRepository;
import io.restassured.RestAssured;
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
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TraderControllerTest {

	@Autowired
	private TraderRepository traderRepository;

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
		if (traderRepository.existsById(testTrader.getId())) {
			traderRepository.delete(testTrader);
		}
	}

	@Test
	void getTradersTest() {
		List<Trader> traders = given()
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.get("/traders/")
				.then()
				.statusCode(HttpStatus.OK.value())
				.and()
				.extract()
				.as(new TypeRef<List<Trader>>() {
				});

		assertThat(traders.contains(testTrader));
	}

	@Test
	void getTraderIdTest() {
		String uri = "/traders/" + testTrader.getId();
		Trader rtnValue =
				given()
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.when()
						.get(uri)
						.then()
						.statusCode(HttpStatus.OK.value())
						.and()
						.extract().as(Trader.class);


		assertNotNull(rtnValue);
	}

	//adam methods below
@Test
void validateTraderEntityRules(){
		assertAll("Null Fields",
				()->{
			//First Name
					Trader fName = new Trader("","last","555-555-5555", "test@test.com","1 test");
					assertThrows(TransactionSystemException.class, ()-> traderRepository.save(fName));
				},
			//Last Name
				()-> {
					Trader lName = new Trader("first","","555-555-5555", "test@test.com","1 test");
					assertThrows(TransactionSystemException.class, () -> traderRepository.save(lName));
				},
			//Phone
				()-> {
					Trader phone = new Trader("first","last","", "test@test.com","1 test");
					assertThrows(TransactionSystemException.class, () -> traderRepository.save(phone));
				},
			//Email
				()-> {
					Trader email = new Trader("first","last","555-555-5555", "","1 test");

						assertThrows(TransactionSystemException.class, () -> traderRepository.save(email));


				},
			//Address
				()-> {
					Trader email = new Trader("first","last","555-555-5555", "test@test.com","");
					assertThrows(TransactionSystemException.class, () -> traderRepository.save(email));

				}


				);
}
	//adam methods above

	//hoa methods below
	@Test
	void removeTraderIdTest() {
		List<Trader> traders = given()

				.accept(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.get("/traders/")
				.then()
				.statusCode(HttpStatus.OK.value())
				.and()
				.extract()
				.as(new TypeRef<List<Trader>>() {
				});

		System.out.println("Orig List");
		traders.forEach(id -> System.out.println(id));
		traders.remove(1);
		System.out.println("Orig List minus the 2nd trader id");
		traders.forEach(id -> System.out.println(id));
//		System.out.println("Orig List Minus one list: " + traders);
//		assertNotNull(rtnValue);
	}


	//hoa methods above

	//mz meth eblow

	//mz method above

	//my methods below

	@Test
	void addSamePersonTwice() {
		given().request().body(testTrader).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.when().post("/traders/")
				.then().statusCode(HttpStatus.BAD_REQUEST.value());
	}

	//my methods above

	// end of TraderControllerTest
}
