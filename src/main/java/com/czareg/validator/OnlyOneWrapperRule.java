package com.czareg.validator;

import java.util.List;
import java.util.function.Predicate;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.exceptions.BookDecoratorException;

public class OnlyOneWrapperRule implements Rule {
	Predicate<String> onlyWrapper = string -> string.equals(BookDecorationBuilder.WRAPPER);

	@Override
	public void isValid(List<String> decorations) {
		Long wrapperCount = decorations.stream().filter(onlyWrapper).count();
		if (wrapperCount > 1) {
			throw new BookDecoratorException("Book can only have 1 wrapper");
		}
	}
}