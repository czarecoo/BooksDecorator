package com.czareg.model;

import com.czareg.interfaces.Publication;

public class Book implements Publication {
	private String author;
	private String title;
	private int numberOfPages;

	public Book(String author, String title, int numberOfPages) {
		this.author = author;
		this.title = title;
		this.numberOfPages = numberOfPages;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String toString() {
		return "|" + this.author + "|" + this.title + "|" + this.numberOfPages + "|";
	}
}