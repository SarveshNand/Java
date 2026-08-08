package LoveBabbarTasks.OOPS.Polymorphism;

public class Nurse extends HealthCareProfessional{
    String shift;

    Nurse(String name, int employeeId, String department, String shift){
        super(name, employeeId, department);
        this.shift = shift;
    }

    @Override
    void work(){
        System.out.println(name + " is checking up patients on " + shift + " shift.");
    }

    void assistPatient(){
        System.out.println(name + "is assisting a patient.");
    }
}
