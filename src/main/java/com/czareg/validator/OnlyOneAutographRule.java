package com.czareg.validator;

import java.util.List;
import java.util.function.Predicate;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.exceptions.BookDecoratorException;

public class OnlyOneAutographRule implements Rule {
	Predicate<String> onlyAutograph = string -> string.equals(BookDecorationBuilder.AUTOGRAPH);

	@Override
	public void isValid(List<String> decorations) {
		Long autographCount = decorations.stream().filter(onlyAutograph).count();
		if (autographCount > 1) {
			throw new BookDecoratorException("Book can only have 1 autograph");
		}
	}
}