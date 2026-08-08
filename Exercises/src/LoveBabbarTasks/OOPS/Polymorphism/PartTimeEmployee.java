package LoveBabbarTasks.OOPS.Polymorphism;

public class PartTimeEmployee extends Employee{
    double hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int employeeId, double hoursWorked, double hourlyRate){
        super(name, employeeId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
