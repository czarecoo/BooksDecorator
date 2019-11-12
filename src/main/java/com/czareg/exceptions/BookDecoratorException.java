package com.czareg.exceptions;

@SuppressWarnings("serial")
public class BookDecoratorException extends RuntimeException {
	public BookDecoratorException(String string) {
		super(string);
	}
}