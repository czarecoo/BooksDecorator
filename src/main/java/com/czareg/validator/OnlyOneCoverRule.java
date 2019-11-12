package com.czareg.validator;

import com.czareg.decorators.BookWithCover;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

public class OnlyOneCoverRule implements Rule {
	@Override
	public void isValid(Publication publication) {
		if (publication instanceof BookWithCover) {
			throw new BookDecoratorException("Book can only have 1 cover");
		}
	}
}