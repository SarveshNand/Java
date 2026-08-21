package ArraysConstructorsThisSuperAndOOP;

public class Apprentice {
    String name;
    double marks;

    Apprentice(String name, double marks){
        this.name = name;
        this.marks = marks;
    }

    void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}
