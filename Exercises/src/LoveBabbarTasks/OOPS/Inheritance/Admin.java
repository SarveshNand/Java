package LoveBabbarTasks.OOPS.Inheritance;

public class Admin extends User{
    Admin(String username, String password){
        super(username, password);
    }

    void responsibility(){
        System.out.println("Admin is managing users and university records.");
    }
}
