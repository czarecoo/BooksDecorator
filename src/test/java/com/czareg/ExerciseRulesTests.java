package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookWithAutograph;
import com.czareg.decorators.BookWithCover;
import com.czareg.decorators.BookWithSoftCover;
import com.czareg.decorators.BookWithWrapper;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

/**
 * Exercise rules: Book can only have:
 * <ol>
 * <li>1 cover</li>
 * <li>1 wrapper</li>
 * <li>1 wrapper and only if it has cover</li> Note: Class BookWithWrapper only
 * takes BookWithCover in its constructor so this rule does not need test.
 * <li>1 autograph no matter other decorations</li>
 * </ol>
 */
public class ExerciseRulesTests extends BookTests {
	@Test
	public void bookCanOnlyHave1Cover() {
		final Publication book = createTestBook();
		final BookWithCover bookWithCover = new BookWithSoftCover(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithSoftCover(bookWithCover);
		});
	}

	@Test
	public void bookCanOnlyHave1Wrapper() {
		final Publication book = createTestBook();
		final BookWithCover bookWithCover = new BookWithSoftCover(book);
		final BookWithWrapper bookWithWrapper = new BookWithWrapper(bookWithCover);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithWrapper(bookWithWrapper);
		});
	}

	@Test
	public void bookCanOnlyHave1Autograph() {
		final Publication book = createTestBook();
		final BookWithAutograph bookWithAutograph = new BookWithAutograph(book, autograph);
		String otherAutograph = "To Cezary for being the greatest.";

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithAutograph(bookWithAutograph, otherAutograph);
		});
	}
}