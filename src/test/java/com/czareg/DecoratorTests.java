package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.interfaces.Publication;
import com.czareg.model.Book;

public class DecoratorTests {
	@Test
	public void BooksToStringMethodShouldReturnProperString() {
		Publication publication = new Book("Adam Mickiewicz", "Pan Tadeusz", 340);

		String result = publication.toString();

		String expected = "|" + publication.getAuthor() + "|" + publication.getTitle() + "|"
				+ publication.getNumberOfPages() + "|";
		Assertions.assertEquals(expected, result, "ToString does not match expected string");
	}
}
