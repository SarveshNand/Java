package LoveBabbarTasks.OOPS.Inheritance;

public class Employee {
    public String name;
    public double salary;

    public Employee(){}
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public void work(){
        System.out.println("Work has been started");
    }
}
