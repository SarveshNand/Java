package LoveBabbarTasks.OOPS.Polymorphism;

public class Surgeon extends HealthCareProfessional{
    String specialization;
    int operationCount;

    Surgeon(String name, int employeeId, String department, String specialization, int operationCount){
        super(name, employeeId, department);
        this.specialization = specialization;
        this.operationCount = operationCount;
    }

    @Override
    void work(){
        System.out.println(name + " is performing surgery as a " + specialization);
    }

    void performSurgery(){
        operationCount++;
        System.out.println(name + " performed Surgery.");
        System.out.println("Total Operations: " + operationCount);
    }
}
