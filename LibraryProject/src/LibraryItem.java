/*
parent class for all Library items
 */
import java.util.Date;
import java.util.Calendar;

public class LibraryItem {

    //attributes
    protected int loan_period; //days
    protected boolean lendable = true;
    private String checkedoutto = null;
    private String title;
    private Date checkedouton;
    private Date duebackon;

    //constructors
    public LibraryItem() {}

    //methods

    public void printDetails(){
        System.out.println("Title: " + this.title);
        if (!this.isCheckedout()) {
            System.out.println("Availability: not checked out");
        }
        else {
            System.out.println("Availability: checked out to " + this.checkedoutto + ", due back on " + this.duebackon);
        }

    }

    // write checkout() method , in not-lendable child classes throws InstantiationException

    // getters + setters

    public Date getCheckedouton() {
        return checkedouton;
    }

    public Date getDuebackon() {
        return duebackon;
    }

    public void setDuebackon() {
        Calendar c = Calendar.getInstance();
        c.setTime(checkedouton);
        c.add(Calendar.DATE, loan_period);
        this.duebackon = c.getTime();
    }

    public void setCheckedouton(Date checkedouton) {
        this.checkedouton = checkedouton;
        //this.setDuebackon();
    }

    public boolean isCheckedout() {
        return (checkedoutto != null);
    }

    protected void setCheckedoutTo(String user_name) {
        this.checkedoutto = user_name;
    }
    protected String getCheckedoutTo() {
        return this.checkedoutto;
    }

    public boolean isLendable() {
        return lendable;
    }
    protected void setLendable(boolean l) {
        this.lendable = l;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public int getLoan_period() {
        return loan_period;
    }

    public void setLoan_period(int l) {
         loan_period = l;
    }

}
