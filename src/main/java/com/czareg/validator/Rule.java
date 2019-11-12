package com.czareg.validator;

import com.czareg.interfaces.Publication;

public interface Rule {
	void isValid(Publication publication);
}
