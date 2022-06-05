package com.bookClub.model;

import java.util.Arrays;
import java.util.List;

public class Book {
	

	private String title,description,isbn,infoUrl;
	private int numOfPages;
	//-------------
	
	public Book() {}


	public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    }

    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
    }


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getInfoUrl() {
		return infoUrl;
	}


	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}


	public int getNumOfPages() {
		return numOfPages;
	}


	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", description=" + description + ", isbn=" + isbn + ", infoUrl=" + infoUrl
				+ ", numOfPages=" + numOfPages + "]";
	}
	
	
	
	
	

}
