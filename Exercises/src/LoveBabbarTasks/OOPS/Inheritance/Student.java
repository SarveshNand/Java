package LoveBabbarTasks.OOPS.Inheritance;

public class Student extends User{
    Student(String username, String password){
        super(username, password);
    }

    void responsibility(){
        System.out.println("Student is attending classes and submitting assignments.");
    }
}
