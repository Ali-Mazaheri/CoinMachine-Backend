package com.assess.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assess.business.validation.BillValidatorEngin;
import com.assess.models.MoneyModel;
import com.assess.models.ResultModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoneyExchangeTests {

	@Autowired
	private BillValidatorEngin billValidatorEngin;

	@Autowired
	private Inventory inventory;

	@Autowired
	private MoneyExchange moneyExchange;

	@Before
	public void before() {

	}

	@Test
	public void exchangeTestOut() {
		ResultModel rm = moneyExchange.exchange(100);
		assertEquals(rm.getSuccess(), false);
		assertEquals(rm.getErrorMessage(), "Not enough coins");
		assertEquals(rm.getData(), null);
	}
	
	@Test
	public void exchangeTestIn20() {
		ResultModel rm = moneyExchange.exchange(20);
		assertEquals(rm.getSuccess(), true);
		assertEquals(rm.getErrorMessage(), "");
		MoneyModel mm = rm.getData();
		assertNotEquals(mm, null);
		assertEquals(mm.getDime() , 0);
		assertEquals(mm.getNickel() , 0);
		assertEquals(mm.getPenny() , 0);
		assertEquals(mm.getQuarter() , 80);
	}

	@Test
	public void exchangeTestIn38() {
		ResultModel rm = moneyExchange.exchange(38);
		assertEquals(rm.getSuccess(), true);
		assertEquals(rm.getErrorMessage(), "");
		MoneyModel mm = rm.getData();
		assertNotEquals(mm, null);
		assertEquals(mm.getQuarter() , 100);
		assertEquals(mm.getDime() , 100);
		assertEquals(mm.getNickel() , 60);
		assertEquals(mm.getPenny() , 0);
		
	}

	
}
