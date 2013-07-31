package com.generalassembly;

public class DVD extends Item {

	private final String director;
	
	public DVD(String pTitle, String pDirector) {
		super(pTitle);
		director = pDirector;
	}
	
	public int GetLoanPeriodDays() {
		return 7;
	}
	
	@Override
	public void PrintDetails() {
		super.PrintDetails();
		System.out.println("Director: " + director);
	}

}
