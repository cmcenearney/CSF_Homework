package com.generalassembly;

public class Library {
	
	public Library() {
	}

	public boolean LoanItemToUser(Item item, User user)
	{
		return item.LoanTo(user);
	}
	
	public void ReturnItem(Item item)
	{
		item.Return();
	}
	
}
