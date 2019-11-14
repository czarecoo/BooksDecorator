package com.czareg.validator;

import java.util.List;

public interface Rule {
	void isValid(List<String> decorations);
}