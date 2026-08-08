package LoveBabbarTasks.OOPS.Polymorphism;

public class Freelancer extends Employee{
    double projectAmount;
    double taxPercentage;

    Freelancer(String name, int employeeId, double projectAmount, double taxPercentage){
        super(name, employeeId);
        this.projectAmount = projectAmount;
        this.taxPercentage = taxPercentage;
    }

    @Override
    double calculateSalary(){
        double tax = projectAmount * taxPercentage / 100;
        return projectAmount - tax;
    }
}
