package LoveBabbarTasks.OOPS.Inheritance;

public class Doctor extends Staff{
    Doctor(int id, String name){
        super(id, name);
    }

    void duty(){
        System.out.println("Doctor is treating patients.");
    }
}
