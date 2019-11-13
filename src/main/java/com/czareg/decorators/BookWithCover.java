package com.czareg.decorators;

import com.czareg.interfaces.Publication;

abstract class BookWithCover extends BookDecorator {
	BookWithCover(Publication publication) {
		super(publication);
	}

	@Override
	public String toString() {
		return publication.toString() + getCover();
	}

	abstract String getCover();
}