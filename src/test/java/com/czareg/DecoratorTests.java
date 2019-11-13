package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.interfaces.Publication;

public class DecoratorTests extends BookTestsBase {
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
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		String result = builder.withHardCover().build().toString();

		String expected = createToStringTemplateForHardCoveredBook(book);
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with hard cover");
	}

	@Test
	public void BooksWithSoftCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		String result = builder.withSoftCover().build().toString();

		String expected = createToStringTemplateForSoftCoveredBook(book);
		Assertions.assertEquals(expected, result, "ToString does not match expected string for book with soft cover");
	}

	@Test
	public void WrappedBookOfBookWithCoverToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		String result = builder.withSoftCover().withNormalWrapper().build().toString();

		String expected = createToStringTemplateForSoftCoveredWrappedBook(book);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for book with soft cover and wrapping");
	}

	@Test
	public void BookWithAutographToStringMethodShouldReturnProperString() {
		Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		String result = builder.withAutograph(autograph).build().toString();

		String expected = createToStringTemplateForAutographedBook(book);
		Assertions.assertEquals(expected, result,
				"ToString does not match expected string for simple book with autograph");
	}
}