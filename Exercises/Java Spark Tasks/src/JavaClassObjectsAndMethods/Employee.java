package JavaClassObjectsAndMethods;

public class Employee {
    int employeeId;
    String employeeName;
    double monthlySalary;
    double salary;

    void addBonus(double percentage){
        salary = salary + (salary*percentage/100);
    }
}
