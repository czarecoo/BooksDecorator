package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookWithAutograph;
import com.czareg.decorators.BookWithCover;
import com.czareg.decorators.BookWithHardCover;
import com.czareg.decorators.BookWithSoftCover;
import com.czareg.decorators.BookWithNormalWrapper;
import com.czareg.interfaces.Publication;

public class DecoratorTests extends BookTests {
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
		BookWithNormalWrapper bookWithWrapper = new BookWithNormalWrapper(bookWithCover);

		String result = bookWithWrapper.toString();

		String expected = createToStringTemplateForSoftCoveredWrappedBook(book);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for book with soft cover and wrapping");
	}

	@Test
	public void BookWithAutographToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookWithAutograph bookWithWrapper = new BookWithAutograph(book, autograph);

		String result = bookWithWrapper.toString();

		String expected = createToStringTemplateForAutographedBook(book);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for simple book with autograph");
	}
}