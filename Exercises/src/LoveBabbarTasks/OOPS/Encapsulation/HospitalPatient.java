package LoveBabbarTasks.OOPS.Encapsulation;

import java.util.ArrayList;

public class HospitalPatient {
    public String patientName;
    public int age;
    public String bloodGroup;
    private ArrayList<String> medicalHistory;

    public HospitalPatient(String patientName, int age, String bloodGroup){
        this.patientName = patientName;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = new ArrayList<>();
    }

    public void addMedicalRecord(String record){
        if (record == null || record.isEmpty()){
            System.out.println("Invalid medical record.");
            return;
        }
        medicalHistory.add(record);
        System.out.println("Medical record added.");
    }
    public void showMedicalHistory(){
        for (String record : medicalHistory){
            System.out.println(record);
        }
    }
    public String getPatientName(){
        return this.patientName;
    }
    public int getAge(){
        return this.age;
    }
    public String getBloodGroup(){
        return this.bloodGroup;
    }
}
