package com.assess.business.validation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assess.business.validation.interfaces.IBillValidatorRuleBase;

@Service
public class BillValidatorEngin {

	private List<IBillValidatorRuleBase> rules;

	public BillValidatorEngin() {
		rules = Arrays.asList(new BillAmountRule(), new BillMaximumRule(), new BillMinimumRule());
	}

	public boolean run(int amount) {
		return rules.stream().allMatch((rule) -> rule.isValid(amount));
	}
}
