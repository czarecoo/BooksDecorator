package com.czareg.decorators;

import com.czareg.interfaces.Publication;

public class BookWithNormalWrapper extends BookWithWrapper {
	public BookWithNormalWrapper(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Wrapped|";
	}
}