package LoveBabbarTasks.OOPS.Polymorphism;

public class Employee {
    String name;
    int employeeId;

    Employee(String name, int employeeId){
        this.name = name;
        this.employeeId = employeeId;
    }

    double calculateSalary(){
        return 0;
    }

    void displayDetails(){
        System.out.println("Name of the employee: " + name);
        System.out.println("Id of the employee: " + employeeId);
        System.out.println("Salary: " + calculateSalary());
    }
}
