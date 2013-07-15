public class DVD extends LibraryItem {
    private int loan_period = 7;
    private boolean checkedout;
    private String director;

    public DVD(String title, String director) {
        super.setTitle(title);
        super.setLoan_period(this.loan_period);
        this.director = director;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("Director: " + this.director);
    }
}
