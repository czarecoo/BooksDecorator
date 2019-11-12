package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookWithAutograph;
import com.czareg.decorators.BookWithCover;
import com.czareg.decorators.BookWithNormalWrapper;
import com.czareg.decorators.BookWithSoftCover;
import com.czareg.decorators.BookWithWrapper;
import com.czareg.exceptions.BookDecoratorException;
import com.czareg.interfaces.Publication;

/**
 * Exercise rules: Book can only have:
 * <ol>
 * <li>1 cover</li>
 * <li>1 wrapper</li>
 * <li>1 wrapper and only if it has cover</li>
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
		final BookWithWrapper bookWithWrapper = new BookWithNormalWrapper(bookWithCover);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithNormalWrapper(bookWithWrapper);
		});
	}

	@Test
	public void bookHasToHaveCoverToBeWrapped() {
		final Publication book = createTestBook();

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithNormalWrapper(book);
		});
	}

	@Test
	public void bookCanOnlyHave1Autograph() {
		final Publication book = createTestBook();
		final BookWithAutograph bookWithAutograph = new BookWithAutograph(book, autograph);
		String otherAutograph = "To Czareg for being the greatest.";

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			new BookWithAutograph(bookWithAutograph, otherAutograph);
		});
	}
}