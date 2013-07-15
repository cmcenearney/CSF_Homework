/*
Have a test method that creates one of each item type, loans them to a user, and prints the user's items.
 */

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTest {

    Library library = new Library();

    @org.junit.Before
    public void setUp() throws Exception {

        library.addUser( new User("Junot Diaz") );
        library.addUser( new User("J.M. Coetzee") );
        library.addUser( new User("Arthur Conan Doyle") );
        library.addItem( new Book("Hamlet","William Shakespeare"));
        library.addItem( new Book("Havana","Elmore Leonard"));
        library.addItem( new Magazine("Surfing for computer programmers",1,1));
        library.addItem( new Magazine("Surfing for computer programmers",1,2));
        library.addItem( new DVD("Harakiri","Masaki Kobayashi"));
        library.addItem( new DVD("Rope","Alfred Hitchcock"));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        library.clearData();
    }

    @Test
    public void testLend()  {

        try {
            library.checkoutItem("Havana", "J.M. Coetzee");
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        try {
            library.checkoutItem("Harakiri", "J.M. Coetzee");
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        try {
            library.checkoutItem("Rope", "J.M. Coetzee");
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        try {
            library.checkoutItem("Surfing for computer programmers", "J.M. Coetzee");
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        library.printItemsLoanedToUser("J.M. Coetzee");

    }

    @Test
    public void test_getTitle()  {
        try {
            library.checkoutItem("non existent title", "J.M. Coetzee");
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Test
    public void testMags_getTitle()  {
        assertEquals(2, library.getByTitle("Surfing for computer programmers").size() );
    }

    @Test
    public void testMagsNotLendable()  {
        LibraryItem mag = library.getByTitle("Surfing for computer programmers").get(0);
        assertEquals(false, mag.isLendable() );
        assertEquals(true, !mag.isLendable() );

    }


    @Test
    public void testAlreadyCheckedOut() {
        try {
            library.checkoutItem("Harakiri", "J.M. Coetzee");
        } catch (Exception e) {
            assertEquals(e.getMessage(), ("item already checked out"));
            System.out.println( e.getMessage()  );
        }
        try {
            library.checkoutItem("Harakiri", "Junot Diaz");
        } catch (Exception e) {
            assertEquals(e.getMessage(), ("item already checked out"));
            System.out.println( e.getMessage()  );
        }

    }

}
