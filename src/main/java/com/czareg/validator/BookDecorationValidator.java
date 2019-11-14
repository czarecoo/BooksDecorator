package com.czareg.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDecorationValidator {
	List<Rule> rules;

	public BookDecorationValidator(Rule... args) {
		rules = new ArrayList<>(Arrays.asList(args));
	}

	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public void validate(List<String> decorations) {
		rules.forEach(rule -> rule.isValid(decorations));
	}
}