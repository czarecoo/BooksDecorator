package com.czareg.decorators;

import com.czareg.interfaces.Publication;

public class BookWithHardCover extends BookWithCover {
	public BookWithHardCover(Publication publication) {
		super(publication);
	}

	@Override
	String getCover() {
		return "Hard Cover|";
	}
}