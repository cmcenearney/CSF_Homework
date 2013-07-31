package com.generalassembly;

public class Magazine extends Item {

	private final int issueNumber;
	
	public Magazine(String pTitle, int pIssueNumber) {
		super(pTitle);
		issueNumber = pIssueNumber;
	}

	public int GetLoanPeriodDays() {
		return 0;
	}
	
	@Override
	public void PrintDetails()
	{
		System.out.println("Issue number: " + issueNumber);
	}
}
