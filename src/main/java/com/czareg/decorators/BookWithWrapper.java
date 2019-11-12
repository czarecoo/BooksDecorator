package com.czareg.decorators;

import com.czareg.interfaces.Publication;
import com.czareg.validator.BookDecorationValidator;
import com.czareg.validator.HasToHaveCoverRule;
import com.czareg.validator.OnlyOneWrapperRule;

public abstract class BookWithWrapper extends BookDecorator {
	public BookWithWrapper(Publication publication) {
		super(publication);
		new BookDecorationValidator(new OnlyOneWrapperRule(), new HasToHaveCoverRule()).validate(publication);
	}

	@Override
	public String toString() {
		return publication.toString() + getCover();
	}

	abstract String getCover();
}