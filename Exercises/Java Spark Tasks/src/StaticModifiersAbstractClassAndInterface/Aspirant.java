package StaticModifiersAbstractClassAndInterface;

public class Aspirant extends User{
    String course;

    Aspirant(String name, String course){
        super(name);
        this.course = course;
    }

    void showAspirantDetails(){
        showName();
        System.out.println("Course: " + course);
    }
}
