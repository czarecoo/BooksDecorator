package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

		String expected = createToStringTemplateForBook(book) + "Hard Cover|";
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with hard cover");
	}

	@Test
	public void BooksWithSoftCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithSoftCover bookWithSoftCover = new BookWithSoftCover(book);

		String result = bookWithSoftCover.toString();

		String expected = createToStringTemplateForBook(book) + "Soft Cover|";
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with soft cover");
	}

	@Test
	public void WrappedBookOfBookWithCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithCover bookWithCover = new BookWithSoftCover(book);
		BookWithWrapper bookWithWrapper = new BookWithWrapper(bookWithCover);

		String result = bookWithWrapper.toString();

		String expected = createToStringTemplateForBook(book) + "Soft Cover|" + "Wrapped|";
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for book with soft cover and wrapping");
	}

	private Book createTestBook() {
		return new Book("Adam Mickiewicz", "Pan Tadeusz", 340);
	}

	private String createToStringTemplateForBook(Publication publication) {
		return "|" + publication.getAuthor() + "|" + publication.getTitle() + "|" + publication.getNumberOfPages()
				+ "|";
	}
}