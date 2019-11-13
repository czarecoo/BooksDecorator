package com.czareg.decorators;

import com.czareg.interfaces.Publication;

abstract class BookWithWrapper extends BookDecorator {
	BookWithWrapper(Publication publication) {
		super(publication);
	}

	@Override
	public String toString() {
		return publication.toString() + getCover();
	}

	abstract String getCover();
}