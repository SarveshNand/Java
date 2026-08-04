package LoveBabbarTasks.OOPS.Intro;

public class Book {
//    Attributes
    public String title;
    public String author;
    public int pages;
//    Methods
    public Book(String title, String author, int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void showBook(){
        System.out.println("Inside showBook()");
        System.out.println("Title of the Book: " + this.title);
        System.out.println("Author of the Book: " + this.author);
        System.out.println("Pages of the Book: " + this.pages);
    }
}
