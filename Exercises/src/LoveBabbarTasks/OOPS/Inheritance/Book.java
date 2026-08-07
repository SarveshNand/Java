package LoveBabbarTasks.OOPS.Inheritance;

public class Book extends LibraryItem{
    int pages;

    Book(String title, String author, int pages) {
        super(title, author);
        this.pages = pages;
    }

    void showDetails() {
        System.out.println("Book: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
    }
}
