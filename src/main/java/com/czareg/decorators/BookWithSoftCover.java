package com.czareg.decorators;

import com.czareg.interfaces.Publication;

class BookWithSoftCover extends BookWithCover {
	BookWithSoftCover(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Soft Cover|";
	}
}