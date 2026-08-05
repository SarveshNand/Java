package LoveBabbarTasks.OOPS.Encapsulation;

public class EmployeeSalary {
    private String employeeName;
    private double salary;

    public EmployeeSalary(String employeeName, double salary){
        this.employeeName = employeeName;
        if (salary >= 0){
            this.salary = salary;
        }
    }

    public void increaseSalary(double percent){
        double sp = this.salary / percent;
        this.salary += sp;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getEmployeeName(){
        return this.employeeName;
    }
}
