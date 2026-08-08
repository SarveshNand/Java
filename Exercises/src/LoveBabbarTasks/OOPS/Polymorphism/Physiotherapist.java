package LoveBabbarTasks.OOPS.Polymorphism;

public class Physiotherapist extends HealthCareProfessional{
    String therapyType;

    Physiotherapist(String name, int employeeId, String department, String therapyType){
        super(name, employeeId, department);
        this.therapyType = therapyType;
    }

    @Override
    void work(){
        System.out.println(name + " is providing " + therapyType + " therapy.");
    }

    void provideTherapy(){
        System.out.println(name + " is providing therapy to a patient.");
    }
}
