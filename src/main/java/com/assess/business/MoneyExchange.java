package com.assess.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assess.models.MoneyModel;
import com.assess.models.ResultModel;

@Service
public class MoneyExchange {

	@Autowired
	private Inventory inventory;

	public ResultModel exchange(int amount) {
		MoneyModel inv = inventory.getInventory();
		MoneyModel res = new MoneyModel();
		InternalReturnType conv;
		int coinCount;
		
		coinCount = inv.getQuarter();
		conv = convertToCoin(amount, coinCount, 0.25);	
		res.setQuarter(conv.coinsCount);
		if (conv.reminder == 0) {
			return new ResultModel("", res, true);
		}
		
		coinCount = inv.getDime();
		conv = convertToCoin(conv.reminder, coinCount, 0.1);	
		res.setDime(conv.coinsCount);
		if (conv.reminder == 0) {
			return new ResultModel("", res, true);
		}
		
		coinCount = inv.getNickel();
		conv = convertToCoin(conv.reminder, coinCount, 0.05);	
		res.setNickel(conv.coinsCount);
		if (conv.reminder == 0) {
			return new ResultModel("", res, true);
		}
		
		coinCount = inv.getPenny();
		conv = convertToCoin(conv.reminder, coinCount, 0.01);	
		res.setPenny(conv.coinsCount);
		if (conv.reminder == 0) {
			return new ResultModel("", res, true);
		}

		return new ResultModel("Not enough coins", null, false);
	}
	
	
	private InternalReturnType convertToCoin (double value, int availableCoinCount, double coinValue) {
		int result =0 ;
		double remainingValue = value;
		if (availableCoinCount > 0) {
			double coinsForBill = remainingValue / coinValue;
			if (coinsForBill <= availableCoinCount) {
				result = (int) coinsForBill;
				remainingValue = remainingValue - coinsForBill * coinValue;
			} else {
				remainingValue = remainingValue - (availableCoinCount * coinValue);
				result= availableCoinCount;
			}
		}
		return new InternalReturnType(result, remainingValue);
	}
	
	class InternalReturnType {
		private int coinsCount;
		private double reminder;
		
		public InternalReturnType(int coinsCount, double reminder) {
			this.coinsCount = coinsCount;
			this.reminder = reminder;
		}
	}
}
