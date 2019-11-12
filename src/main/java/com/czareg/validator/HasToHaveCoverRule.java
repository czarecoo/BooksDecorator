package com.czareg.validator;

import com.czareg.decorators.BookWithCover;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

public class HasToHaveCoverRule implements Rule {
	@Override
	public void isValid(Publication publication) {
		if (!(publication instanceof BookWithCover)) {
			throw new BookDecoratorException("Book has to have cover to put on wrapper");
		}
	}
}