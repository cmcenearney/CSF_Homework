package com.generalassembly;

import java.util.Date;

public abstract class Item {
	
	private final String title;
	private User loanedTo = null;
	private Date dueDate;

	public Item(String pTitle) {
		title = pTitle;
	}

	public boolean GetIsAvailable() {
		return (loanedTo == null);
	}
	
	// If the item is loanable and the user is not delinquent, associate this item with the user.
	public boolean LoanTo(User user) {
		
		if (!GetIsAvailable()) {
			System.out.println("Loan declined; item is currently checked out to " + loanedTo.GetName());
			return false;
		}
		
		if (user.IsDelinquent()) {
			System.out.println("Loan declined; user has delinquent items.");
			return false;
		}
		
		dueDate = new Date();
		int loanDays = GetLoanPeriodDays();
		
		if (loanDays == 0) {
			System.out.println("Loan declined; item " + title + " is not loanable.");
			return false;
		}
		
		long loanMilliseconds = loanDays * 24 * 60 * 60 * 1000;
		dueDate.setTime(System.currentTimeMillis() + loanMilliseconds);
		
		user.AddItemToUserCollection(this);
		loanedTo = user;
		System.out.println("Loaned " + title + " to " + user.GetName());
		
		return true;
	}
	
	public void Return() {
		if (loanedTo != null) {
			loanedTo.RemoveItemFromUserCollection(this);
			loanedTo = null;
		}
	}
	
	public Date GetDueDate() {
		return dueDate;
	}
	
	public String GetTitle() {
		return title;
	}
	
	public void PrintDetails() {
		System.out.println("Title: " + title);
		if (loanedTo == null) {
			System.out.println("Currently available.");
		} else {
			System.out.println("On loan to " + loanedTo.GetName() + ", due back on " + dueDate.toString());
		}
	}
	
	abstract int GetLoanPeriodDays();
}
