package LoveBabbarTasks.OOPS.Polymorphism;

public class FullTimeEmployee extends Employee{
    double monthlySalary;
    double bonus;

    FullTimeEmployee(String name, int employeeId, double monthlySalary, double bonus){
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary(){
        return monthlySalary + bonus;
    }
}
