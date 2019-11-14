package com.czareg.decorators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.czareg.interfaces.Publication;
import com.czareg.validator.BookDecorationValidator;
import com.czareg.validator.HasToHaveCoverRule;
import com.czareg.validator.OnlyOneAutographRule;
import com.czareg.validator.OnlyOneCoverRule;
import com.czareg.validator.OnlyOneWrapperRule;

public class BookDecorationBuilder {
	public static final String WRAPPER = "Wrapper";
	public static final String COVER = "Cover";
	public static final String AUTOGRAPH = "Autograph";

	private Publication publication;
	private BookDecorationValidator bookDecorationValidator;
	private List<String> decorations;

	public BookDecorationBuilder(Publication book) {
		Objects.requireNonNull(book, "Null book in this builder make no sense");
		this.publication = book;
		bookDecorationValidator = new BookDecorationValidator(new OnlyOneWrapperRule());
		bookDecorationValidator.addRule(new HasToHaveCoverRule());
		bookDecorationValidator.addRule(new OnlyOneCoverRule());
		bookDecorationValidator.addRule(new OnlyOneAutographRule());
		decorations = new ArrayList<>();
	}

	public BookDecorationBuilder withAutograph(String autograph) {
		Objects.requireNonNull(autograph, "Null autograph make no sense");
		publication = new BookWithAutograph(publication, autograph);
		decorations.add(AUTOGRAPH);
		return this;
	}

	public BookDecorationBuilder withHardCover() {
		publication = new BookWithHardCover(publication);
		decorations.add(COVER);
		return this;
	}

	public BookDecorationBuilder withSoftCover() {
		publication = new BookWithSoftCover(publication);
		decorations.add(COVER);
		return this;
	}

	public BookDecorationBuilder withNormalWrapper() {
		publication = new BookWithNormalWrapper(publication);
		decorations.add(WRAPPER);
		return this;
	}

	public Publication build() {
		bookDecorationValidator.validate(decorations);
		return publication;
	}
}