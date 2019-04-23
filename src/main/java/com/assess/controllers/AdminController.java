package com.assess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assess.business.Inventory;
import com.assess.models.MoneyModel;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private Inventory inventory;
	
	@RequestMapping(path="/topupInventory", method = RequestMethod.POST)
	public MoneyModel topupInventory(@RequestBody MoneyModel money) {
		inventory.topupInventory(money);
		return inventory.getInventory();
	}

	@RequestMapping(path="/setInventory", method = RequestMethod.POST)
	public MoneyModel setInventory(@RequestBody MoneyModel money) {
		inventory.clearInventory();
		inventory.topupInventory(money);
		return inventory.getInventory();
	}
	
	@RequestMapping(path="/getInventory", method = RequestMethod.GET)
	public MoneyModel getInventory() {
		return inventory.getInventory();
	}
	
}
