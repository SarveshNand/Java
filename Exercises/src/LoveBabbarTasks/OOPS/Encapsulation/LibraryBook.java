package LoveBabbarTasks.OOPS.Encapsulation;

public class LibraryBook {
    private String title;
    private String author;
    private boolean isIssued;

    public LibraryBook(String title, String author){
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issueBook(){
        if (isIssued){
            System.out.println("Book is already Issued.");
            return;
        }
        isIssued = true;
        System.out.println("Book issued successfully.");
    }

    public void returnBook(){
        if (!isIssued){
            System.out.println("Book is already returned.");
            return;
        }
        isIssued = false;
        System.out.println("Book returned successfully.");
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }
}
