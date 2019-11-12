package com.czareg.decorators;

import com.czareg.interfaces.Publication;

public abstract class BookWithCover extends BookDecorator {
	public BookWithCover(Publication publication) {
		super(publication);
	}

	@Override
	public String toString() {
		return publication.toString() + getCover();
	}

	abstract String getCover();
}