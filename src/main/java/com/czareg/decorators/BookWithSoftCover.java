package com.czareg.decorators;

import com.czareg.interfaces.Publication;

public class BookWithSoftCover extends BookWithCover {
	public BookWithSoftCover(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Soft Cover|";
	}
}