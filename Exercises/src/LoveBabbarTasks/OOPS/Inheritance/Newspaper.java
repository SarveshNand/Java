package LoveBabbarTasks.OOPS.Inheritance;

public class Newspaper extends LibraryItem{
    String publicationDate;

    Newspaper(String title, String author, String publicationDate) {
        super(title, author);
        this.publicationDate = publicationDate;
    }

    void showDetails() {
        System.out.println("Newspaper: " + title);
        System.out.println("Publisher: " + author);
        System.out.println("Publication Date: " + publicationDate);
    }
}
