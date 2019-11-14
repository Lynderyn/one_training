package com.acme.acmetrade.endpoints;

import com.acme.acmetrade.domain.Account;
import com.acme.acmetrade.domain.Currency;
import com.acme.acmetrade.domain.Trader;
import com.acme.acmetrade.repository.AccountRepository;
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
	private AccountRepository accountRepository;
	@Autowired
	private TraderRepository traderRepository;
	@Autowired
	private AccountController accountController;

	private Trader testTrader;
	private Account testAccount;

	@BeforeEach
	void initData() {
		Trader myTrader = new Trader();
		myTrader.setfName("first");
		myTrader.setlName("last");
		myTrader.setAddress("1 test");
		myTrader.setEmail("test@test.com");
		myTrader.setPhone("555-555-5555");
		testTrader = traderRepository.save(myTrader);
		Account myAccount = new Account();
		myAccount.setAccountNumber("666");
		myAccount.setBalance(777.77);
		myAccount.setCurrency(Currency.USD);
		myAccount.setTrader(testTrader);
		testAccount = accountRepository.save(myAccount);
	}

	@AfterEach
	void killData() {
		if(accountRepository.existsById(testAccount.getId())) {
			accountRepository.delete(testAccount);
		}
		if(traderRepository.existsById(testTrader.getId())) {
			traderRepository.delete(testTrader);
		}
	}

	@Test
	void testGetAccounts() {
		List<Account> accounts =
		given().accept(MediaType.APPLICATION_JSON_VALUE)
		.when().get("/accounts/")
		.then()
		.statusCode(HttpStatus.OK.value())
		.and()
		.extract()
		.as(new TypeRef<List<Account>>() {
		});
		assertTrue(accounts.contains(testAccount));
	}

	//adam methods below

    //adam methods above

    //hoa methods below

    //hoa methods above

    //mz meth below
	
    //mz method above

    //jesse methods below

    //my methods above

} // end of TraderControllerTest
