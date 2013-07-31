package com.generalassembly;

public class Book extends Item {

	private final String author;
	
	public Book(String pTitle, String pAuthor) {
		super(pTitle);
		author = pAuthor;
	}

	public int GetLoanPeriodDays() {
		return 14;
	}
	
	@Override
	public void PrintDetails() {
		super.PrintDetails();
		System.out.println("Author: " + author);
	}
}
