package com.czareg.decorators;

import com.czareg.interfaces.Publication;
import com.czareg.validator.BookDecorationValidator;
import com.czareg.validator.OnlyOneCoverRule;

public abstract class BookWithCover extends BookDecorator {
	public BookWithCover(Publication publication) {
		super(publication);
		new BookDecorationValidator(new OnlyOneCoverRule()).validate(publication);
	}

	@Override
	public String toString() {
		return publication.toString() + getCover();
	}

	abstract String getCover();
}