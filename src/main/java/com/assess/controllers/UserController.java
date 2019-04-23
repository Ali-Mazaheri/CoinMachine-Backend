package com.assess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assess.business.Inventory;
import com.assess.business.MoneyExchange;
import com.assess.business.validation.BillValidatorEngin;
import com.assess.models.MoneyModel;
import com.assess.models.ResultModel;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private BillValidatorEngin billValidatorEngin;
	
	@Autowired
	private Inventory inventory;
	
	@Autowired
	private MoneyExchange moneyExchange;
	
	@RequestMapping(path = "/billInserted", method = RequestMethod.POST)
	public ResultModel billInserted(@RequestBody int value) {
		boolean validBill = billValidatorEngin.run(value);
		if(!validBill) {
			return new ResultModel("Illegal Ammount", null, false);
		}
		
		return moneyExchange.exchange(value);
	}
	
	@RequestMapping(path = "/userApproved", method = RequestMethod.POST)
	public boolean userApproved(@RequestBody MoneyModel money) {
		inventory.deduct(money);
		return true;
	}

}
