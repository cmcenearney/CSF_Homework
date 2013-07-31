package com.generalassembly;

public class LibraryTest {

	/*
	 * Sample output:

Loaned War and Peace to Big Bird
Loan declined; item Scientific American is not loanable.
Loaned The Avengers to Big Bird

Collection details for user Big Bird:

Title: War and Peace
On loan to Big Bird, due back on Wed Nov 28 09:47:46 EST 2012
Author: Leo Tolstoy

Title: The Avengers
On loan to Big Bird, due back on Wed Nov 21 09:47:46 EST 2012
Director: Joss Whedon

	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Library library = new Library();
		
		Book warAndPeace = new Book("War and Peace", "Leo Tolstoy");
		Magazine scientificAmerican = new Magazine("Scientific American", 234);
		DVD theAvengers = new DVD("The Avengers", "Joss Whedon");
		
		User bigBird = new User("Big Bird");
		
		library.LoanItemToUser(warAndPeace, bigBird);
		library.LoanItemToUser(scientificAmerican,  bigBird);
		library.LoanItemToUser(theAvengers,  bigBird);
		
		bigBird.PrintCollectionDetails();
	}

}
