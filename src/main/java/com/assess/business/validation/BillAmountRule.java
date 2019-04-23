package com.assess.business.validation;

import java.util.Arrays;
import java.util.List;

import com.assess.business.validation.interfaces.IBillValidatorRuleBase;

public class BillAmountRule implements IBillValidatorRuleBase {

	private final List<Integer> validAmount = Arrays.asList(1, 2, 5, 10, 20, 50, 100);

	@Override
	public boolean isValid(int amount) {
		return validAmount.stream().anyMatch(item-> item == amount);
	}

}
