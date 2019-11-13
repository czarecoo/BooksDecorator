package com.czareg.decorators;

import com.czareg.interfaces.Publication;

class BookWithAutograph extends BookDecorator {
	String autograph;

	BookWithAutograph(Publication publication, String autograph) {
		super(publication);
		this.autograph = autograph;
	}

	@Override
	public String toString() {
		return publication.toString() + autograph + "|";
	}
}