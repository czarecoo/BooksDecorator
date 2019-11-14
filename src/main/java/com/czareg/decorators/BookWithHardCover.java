package com.czareg.decorators;

import com.czareg.interfaces.Publication;

class BookWithHardCover extends BookWithCover {
	BookWithHardCover(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Hard Cover|";
	}
}