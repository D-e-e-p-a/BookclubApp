package com.bookClub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Field;

public class WishlistItem {
	
	
	@Id
	private String id;
	
	

	@NotNull
	@NotEmpty(message ="ISBN is a required field")
	private String isbn;
	

	@NotNull
	@NotEmpty(message ="Title is a required field")
	private String title;
	
	public WishlistItem() {}
	
	
	public WishlistItem(@NotNull @NotEmpty(message = "ISBN is a required field") String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id=id2;
		
	}
	public void setId() {
		
		
	}

	

	@Override
	public String toString() {
		return "WishlistItem [Id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
	}


	

	
	

}
