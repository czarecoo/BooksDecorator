package com.czareg.validator;

import com.czareg.decorators.BookWithAutograph;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

public class OnlyOneAutographRule implements Rule {
	@Override
	public void isValid(Publication publication) {
		if (publication instanceof BookWithAutograph) {
			throw new BookDecoratorException("Book can only have 1 autograph");
		}
	}
}