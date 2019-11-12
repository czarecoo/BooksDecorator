package com.czareg.decorators;

import com.czareg.interfaces.Publication;

public class BookWithAutograph extends BookDecorator {
	String autograph;

	public BookWithAutograph(Publication publication, String autograph) {
		super(publication);
		this.autograph = autograph;
	}

	@Override
	public String toString() {
		return publication.toString() + autograph + "|";
	}
}