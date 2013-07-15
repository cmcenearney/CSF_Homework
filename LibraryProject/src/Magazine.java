public class Magazine extends LibraryItem {

    private final boolean lendable = false;

    private int volume;
    private int issue;

    public Magazine(String title, int volume, int issue) {
        super.setTitle(title);
        super.setLendable(this.lendable);
        this.volume = volume;
        this.issue = issue;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("Volume: " + this.volume);
        System.out.println("Issue: " + this.issue);
    }
}
