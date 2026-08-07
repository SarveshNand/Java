package LoveBabbarTasks.OOPS.Inheritance;

public class Manager extends Employee{
    public Manager(String name, double salary){
        super(name, salary);
    }

    public void conductMeeting(){
        System.out.println("I'll be conducting a meeting everyone.");
    }
}
