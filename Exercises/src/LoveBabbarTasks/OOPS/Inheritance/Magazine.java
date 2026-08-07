package LoveBabbarTasks.OOPS.Inheritance;

public class Magazine extends LibraryItem{
    int issueNumber;

    Magazine(String title, String author, int issueNumber) {
        super(title, author);
        this.issueNumber = issueNumber;
    }

    void showDetails() {
        System.out.println("Magazine: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issue Number: " + issueNumber);
    }
}
