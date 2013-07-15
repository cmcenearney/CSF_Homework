public class Book extends LibraryItem {

    private int loan_period = 28;
    private boolean checkedout;
    private String author;


    public Book(String title, String author) {
        super.setTitle(title);
        super.setLoan_period(this.loan_period);
        this.author = author;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("Author: " + this.author);
    }

}
