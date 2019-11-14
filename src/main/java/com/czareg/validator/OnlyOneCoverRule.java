package com.czareg.validator;

import java.util.List;
import java.util.function.Predicate;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.exceptions.BookDecoratorException;

public class OnlyOneCoverRule implements Rule {
	Predicate<String> onlyCover = string -> string.equals(BookDecorationBuilder.COVER);

	@Override
	public void isValid(List<String> decorations) {
		Long coverCount = decorations.stream().filter(onlyCover).count();
		if (coverCount > 1) {
			throw new BookDecoratorException("Book can only have 1 cover");
		}
	}
}