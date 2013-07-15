/*
================
Library homework
================

Due: Monday July 15, 2013

Design and implement a basic public library system, that implements a Library class that manages loans of items to users.

The system must:

    - Handle different kinds of items, such as books, magazines, and DVD's. Each item type may have different loan periods,
    and have different item details (ie, author of a book, issue number of a magazine, director of a DVD.) However, every item has a title.
    - Have a method to loan an item to a user. A loan is only successful if the user has no overdue items, the item is
    loanable (ie, magazines cannot be checked out,) and the item is not currently checked out to another user.
    - Have a method to return an item to the library.
    - Have a method to print the details of all items currently on loan to a specific user, along with their due dates.
    - Have a test method that creates one of each item type, loans them to a user, and prints the user's items.

Sample output:

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

public class Application {
    public static void main (String[] args){

    }
}
