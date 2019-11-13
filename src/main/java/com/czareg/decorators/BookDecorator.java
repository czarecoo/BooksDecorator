package com.czareg.decorators;

import com.czareg.interfaces.Publication;

class BookDecorator implements Publication {
	Publication publication;

	BookDecorator(Publication publication) {
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