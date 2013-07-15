/*
the Brainz!
controller / main system for Library project
 */

import java.util.*;

public class Library {

    private List<LibraryItem> inventory = new ArrayList();
    private List<User> users = new ArrayList();

    public void loanItem(String title, String user_name){
        //if the user has no overdue items,
        //the item is loanable (ie, magazines cannot be checked out)
        //the item is not currently checked out to another user

    }

    public void addItem(LibraryItem item) {
        this.inventory.add(item);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void clearData() {
        this.users.clear();
        this.inventory.clear();
    }

    public ArrayList<LibraryItem> getByTitle(String title)  {
        ArrayList<LibraryItem> results = new ArrayList<LibraryItem>();
        for (LibraryItem i: this.inventory) {
            if (i.getTitle().equals(title)) {
                results.add(i);
            }
        }
        return results;
    }

    public ArrayList<LibraryItem> listItemsLoanedToUser(String name){
        ArrayList<LibraryItem> results = new ArrayList<LibraryItem>();
        for (LibraryItem i: this.inventory) {
            if (i.isCheckedout()) {
                if ( i.getCheckedoutTo().equals(name)) {
                results.add(i);
                }
            }
        }
        return results;
    }

    public ArrayList<LibraryItem> getOverdueItems(String user_name){
        Date current = new Date();
        ArrayList<LibraryItem> results = new ArrayList<LibraryItem>();
        ArrayList<LibraryItem> checked_out =  listItemsLoanedToUser(user_name);
        for (LibraryItem i: checked_out) {
            if ( i.getDuebackon().before(current) ) {
                results.add(i);
            }
        }
        return results;
    }

    public void  printItemsLoanedToUser(String name){
        ArrayList<LibraryItem> items = listItemsLoanedToUser(name);
        for (LibraryItem i: items) {
             i.printDetails();
        }
    }

    public void checkoutItem(String title, String user_name) throws  Exception{
        //this method should check whether user has overdue items + whether item is checked out
        // ? - item's checkout() method should handle lendability?

        if ( getOverdueItems(user_name).size() > 0 ) {
            throw new Exception("ovedue items");
        }

        ArrayList<LibraryItem> items =  getByTitle(title);
        if (items.size() == 0) {
            throw new Exception("no item found with that title");
        }
        else if (items.size() > 1) {
           //throw an Exception for more than one item with same title   ?
        }
        else {
            LibraryItem item = items.get(0);
            if ( item.isLendable() == false ) {
                throw new Exception("item not loanable");
            }
            else if ( item.isCheckedout() ) {
                throw new Exception("item already checked out");
            }
            else {  //check it out!
                item.setCheckedoutTo(user_name);
                item.setCheckedouton(new Date());
                item.setDuebackon();
            }
        }
    }

    public void returnItem (String title) {
        ArrayList<LibraryItem> items =  getByTitle(title);
        if (items.size() > 1) {
            // throw an Exception for more than one item with same title   ?
        }
        else {
            LibraryItem item = items.get(0);
            item.setCheckedoutTo(null);
        }
    }

    public void printInventoryList () {
        for (LibraryItem i: this.inventory) {
            i.printDetails();
        }
    }

}
