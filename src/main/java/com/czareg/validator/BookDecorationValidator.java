package com.czareg.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.czareg.interfaces.Publication;

public class BookDecorationValidator {
	List<Rule> rules;

	public BookDecorationValidator(Rule... args) {
		rules = new ArrayList<>(Arrays.asList(args));
	}

	public void validate(Publication publication) {
		rules.forEach(rule -> rule.isValid(publication));
	}
}