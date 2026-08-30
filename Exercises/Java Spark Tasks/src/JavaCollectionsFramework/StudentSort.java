package JavaCollectionsFramework;

public class StudentSort {
    int id;
    String name;
    double marks;

    public StudentSort(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
