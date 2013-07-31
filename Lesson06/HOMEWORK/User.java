package com.generalassembly;

import java.util.ArrayList;
import java.util.Date;

public class User {

	private ArrayList<Item> collection = new ArrayList<Item>();
	private final String userName;
	
	public User(String name) {
		userName = name;
	}
	
	public String GetName() {
		return userName;
	}
	
	public boolean IsDelinquent() 
	{
		long now = System.currentTimeMillis();
		
		for (Item item : collection) {
			Date dueDate = item.GetDueDate();
			if (dueDate.getTime() < now) {
				System.out.println("User " + userName + " has an overdue item: " + item.GetTitle());
				return true;
			}
		}
		return false;
	}

	public void AddItemToUserCollection(Item item)
	{
		collection.add(item);
	}
	
	public void RemoveItemFromUserCollection(Item item)
	{
		collection.remove(item);
	}
	
	public void PrintCollectionDetails()
	{
		System.out.println("\nCollection details for user " + userName + ":\n");
		for (Item item : collection) {
			item.PrintDetails();
			System.out.println();
		}
	}
}
