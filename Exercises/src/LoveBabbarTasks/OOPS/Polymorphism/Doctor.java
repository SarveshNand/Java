package LoveBabbarTasks.OOPS.Polymorphism;

public class Doctor extends HealthCareProfessional{
    String specialization;

    Doctor(String name, int employeeId, String department, String specialization){
        super(name, employeeId, department);
        this.specialization = specialization;
    }

    @Override
    void work(){
        System.out.println(name + " is diagnosing patients as a " + specialization);
    }

    void diagnosePatient(){
        System.out.println(name + "is diagnosing a patient.");
    }
}
