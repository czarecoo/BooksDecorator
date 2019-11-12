package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookWithAutograph;
import com.czareg.decorators.BookWithCover;
import com.czareg.decorators.BookWithHardCover;
import com.czareg.decorators.BookWithSoftCover;
import com.czareg.decorators.BookWithWrapper;
import com.czareg.interfaces.Publication;
import com.czareg.model.Book;

public class DecoratorTests {
	@Test
	public void BooksToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();

		String result = book.toString();

		String expected = createToStringTemplateForBook(book);
		Assertions.assertEquals(expected, result, "ToString does not match expected string for simple book");
	}

	@Test
	public void BooksWithHardCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithHardCover bookWithHardCover = new BookWithHardCover(book);

		String result = bookWithHardCover.toString();

		String expected = createToStringTemplateForHardCoveredBook(book);
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with hard cover");
	}

	@Test
	public void BooksWithSoftCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithSoftCover bookWithSoftCover = new BookWithSoftCover(book);

		String result = bookWithSoftCover.toString();

		String expected = createToStringTemplateForSoftCoveredBook(book);
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with soft cover");
	}

	@Test
	public void WrappedBookOfBookWithCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithCover bookWithCover = new BookWithSoftCover(book);
		BookWithWrapper bookWithWrapper = new BookWithWrapper(bookWithCover);

		String result = bookWithWrapper.toString();

		String expected = createToStringTemplateForSoftCoveredWrappedBook(book);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for book with soft cover and wrapping");
	}

	@Test
	public void BookWithAutographToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		String autograph = "To my dearest, Alice";
		BookWithAutograph bookWithWrapper = new BookWithAutograph(book, autograph);

		String result = bookWithWrapper.toString();

		String expected = createToStringTemplateForAutographedBook(book, autograph);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for simple book with autograph");
	}

	private Book createTestBook() {
		return new Book("Adam Mickiewicz", "Pan Tadeusz", 340);
	}

	private String createToStringTemplateForBook(Publication publication) {
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

	private String createToStringTemplateForHardCoveredBook(Publication book) {
		return createToStringTemplateForBook(book) + "Hard Cover|";
	}

	private String createToStringTemplateForSoftCoveredBook(Publication book) {
		return createToStringTemplateForBook(book) + "Soft Cover|";
	}

	private String createToStringTemplateForSoftCoveredWrappedBook(Publication book) {
		return createToStringTemplateForSoftCoveredBook(book) + "Wrapped|";
	}

	private String createToStringTemplateForAutographedBook(Publication book, String autograph) {
		return createToStringTemplateForBook(book) + autograph + "|";
	}
}