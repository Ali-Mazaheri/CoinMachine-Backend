package com.assess.business.validation;

import com.assess.business.validation.interfaces.IBillValidatorRuleBase;

public class BillMinimumRule implements IBillValidatorRuleBase{

	private final int min = 1;
	
	@Override
	public boolean isValid(int amount) {
		return amount >= min;
	}
}