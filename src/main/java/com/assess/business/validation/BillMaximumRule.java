package com.assess.business.validation;

import com.assess.business.validation.interfaces.IBillValidatorRuleBase;

public class BillMaximumRule implements IBillValidatorRuleBase{

	private final int max = 100;
	
	@Override
	public boolean isValid(int amount) {
		return amount <= max;
	}
}
