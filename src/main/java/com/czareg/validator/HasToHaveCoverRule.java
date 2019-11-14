package com.czareg.validator;

import java.util.List;
import java.util.function.Predicate;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.exceptions.BookDecoratorException;

public class HasToHaveCoverRule implements Rule {
	Predicate<String> onlyCover = string -> string.equals(BookDecorationBuilder.COVER);
	Predicate<String> onlyWrapper = string -> string.equals(BookDecorationBuilder.WRAPPER);

	@Override
	public void isValid(List<String> decorations) {
		Long wrapperCount = decorations.stream().filter(onlyWrapper).count();
		Long coverCount = decorations.stream().filter(onlyCover).count();
		if (wrapperCount > 0 && coverCount == 0) {
			throw new BookDecoratorException("Book has to have cover to put on wrapper");
		}
	}
}