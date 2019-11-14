package com.czareg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.czareg.decorators.BookDecorationBuilder;
import com.czareg.interfaces.Publication;

public class BuilderTests extends BookTestsBase {
	@Test
	public void builderWithOnlyBuildShouldReturnCreatedBook() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Publication result = builder.build();

		Assertions.assertEquals(result, book,
				"Empty builder build() product should be equal to book passed as parameter to builder.");
	}

	@Test
	public void buildersConstructorShouldThrowExceptionWhenPassedNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new BookDecorationBuilder(null);
		});
	}

	@Test
	public void withAutographMethodShouldThrowExceptionWhenPassedNull() {
		final Publication book = createTestBook();
		BookDecorationBuilder builder = new BookDecorationBuilder(book);

		Assertions.assertThrows(NullPointerException.class, () -> {
			builder.withAutograph(null);
		});
	}
}