package com.czareg;

import com.czareg.interfaces.Publication;
import com.czareg.model.Book;

public class BookTestsBase {
	static String autograph = "To my dearest, Alice";
	static String otherAutograph = "To Czareg for being the greatest.";

	protected Book createTestBook() {
		return new Book("Adam Mickiewicz", "Pan Tadeusz", 340);
	}

	protected String createToStringTemplateForBook(Publication publication) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|");
		stringBuilder.append(publication.getAuthor());
		stringBuilder.append("|");
		stringBuilder.append(publication.getTitle());
		stringBuilder.append("|");
		stringBuilder.append(publication.getNumberOfPages());
		stringBuilder.append("|");
		return stringBuilder.toString();
	}

	protected String createToStringTemplateForHardCoveredBook(Publication book) {
		return createToStringTemplateForBook(book) + "Hard Cover|";
	}

	protected String createToStringTemplateForSoftCoveredBook(Publication book) {
		return createToStringTemplateForBook(book) + "Soft Cover|";
	}

	protected String createToStringTemplateForSoftCoveredWrappedBook(Publication book) {
		return createToStringTemplateForSoftCoveredBook(book) + "Wrapped|";
	}

	protected String createToStringTemplateForAutographedBook(Publication book) {
		return createToStringTemplateForBook(book) + autograph + "|";
	}
}