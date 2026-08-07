package LoveBabbarTasks.OOPS.Inheritance;

public class LibraryItem {
    String title;
    String author;

    LibraryItem(String title, String author){
        this.title = title;
        this.author = author;
    }

    void borrow(){
        System.out.println(title + " has been borrowed.");
    }

    void returnItem(){
        System.out.println(title + " has been returned.");
    }
}
