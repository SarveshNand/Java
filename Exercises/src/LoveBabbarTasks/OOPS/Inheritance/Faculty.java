package LoveBabbarTasks.OOPS.Inheritance;

public class Faculty extends User{
    Faculty(String username, String password){
        super(username, password);
    }

    void responsibility(){
        System.out.println("Faculty is teaching students and managing courses.");
    }
}
