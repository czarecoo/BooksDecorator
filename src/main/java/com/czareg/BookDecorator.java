package com.czareg;

public class BookDecorator implements Publication {
	Publication publication;

	public BookDecorator(Publication publication) {
		this.publication = publication;
	}

	public String getAuthor() {
		return publication.getAuthor();
	}

	public String getTitle() {
		return publication.getTitle();
	}

	public int getNumberOfPages() {
		return publication.getNumberOfPages();
	}
}