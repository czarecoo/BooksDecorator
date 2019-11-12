package com.czareg.decorators;

import com.czareg.interfaces.Publication;
import com.czareg.validator.BookDecorationValidator;
import com.czareg.validator.OnlyOneAutographRule;

public class BookWithAutograph extends BookDecorator {
	String autograph;

	public BookWithAutograph(Publication publication, String autograph) {
		super(publication);
		new BookDecorationValidator(new OnlyOneAutographRule()).validate(publication);
		this.autograph = autograph;
	}

	@Override
	public String toString() {
		return publication.toString() + autograph + "|";
	}
}