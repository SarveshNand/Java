package LoveBabbarTasks.OOPS.Polymorphism;

public class HealthCareProfessional {
    String name;
    int employeeId;
    String department;

    HealthCareProfessional(String name, int employeeId, String department){
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }

    void work(){
        System.out.println(name + " is working.");
    }

    void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Department: " + department);
    }
}
