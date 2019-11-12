package com.czareg.validator;

import com.czareg.decorators.BookWithNormalWrapper;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

public class OnlyOneWrapperRule implements Rule {
	@Override
	public void isValid(Publication publication) {
		if (publication instanceof BookWithNormalWrapper) {
			throw new BookDecoratorException("Book can only have 1 wrapper");
		}
	}
}