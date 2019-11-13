package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookDecorationBuilder;
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
public class ExerciseRulesTests extends BookTestsBase {
	@Test
	public void bookCanOnlyHave1Cover() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			builder.withSoftCover().withHardCover().build();
		});
	}

	@Test
	public void bookCanOnlyHave1Wrapper() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			builder.withSoftCover().withNormalWrapper().withNormalWrapper().build();
		});
	}

	@Test
	public void bookHasToHaveCoverToBeWrapped() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			builder.withNormalWrapper().build();
		});
	}

	@Test
	public void bookCanOnlyHave1Autograph() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			builder.withAutograph(autograph).withAutograph(otherAutograph).build();
		});
	}

	@Test
	public void bookWithCoverAndAutographShouldStillThrowExceptionWhenTryingToAddAnotherCover() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(BookDecoratorException.class, () -> {
			builder.withSoftCover().withAutograph(autograph).withHardCover().build();
		});
	}
}