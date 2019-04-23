package com.assess.business;

import org.springframework.stereotype.Service;

import com.assess.models.MoneyModel;

@Service
public class Inventory {
	private final MoneyModel inventory = new MoneyModel(100, 100, 100, 100);

	public double getAmount() {
		return inventory.value();
	}
	
	public MoneyModel getInventory() {
		return inventory;
	}

	public void topupInventory(MoneyModel money) {
		inventory.add(money);
	}

	public void deduct(MoneyModel money) {
		inventory.deduct(money);
	}

	public void clearInventory() {
		inventory.clear();
	}
}
