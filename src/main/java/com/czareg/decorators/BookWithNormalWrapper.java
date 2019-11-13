package com.czareg.decorators;

import com.czareg.interfaces.Publication;

class BookWithNormalWrapper extends BookWithWrapper {
	BookWithNormalWrapper(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Wrapped|";
	}
}