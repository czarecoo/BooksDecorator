package com.czareg.decorators;

public class BookWithWrapper extends BookWithCover {
	public BookWithWrapper(BookWithCover bookWithCover) {
		super(bookWithCover);
	}

	@Override
	String getCover() {
		return "Wrapped|";
	}
}