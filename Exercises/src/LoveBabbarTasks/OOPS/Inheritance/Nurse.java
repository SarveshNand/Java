package LoveBabbarTasks.OOPS.Inheritance;

public class Nurse extends Staff{
    Nurse(int id, String name){
        super(id, name);
    }

    void duty(){
        System.out.println("Nurse is taking care of patients.");
    }
}
