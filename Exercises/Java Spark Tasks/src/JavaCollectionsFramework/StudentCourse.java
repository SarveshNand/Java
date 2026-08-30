package JavaCollectionsFramework;

public class StudentCourse {
    int id;
    String name;
    String email;
    int marks;

    public StudentCourse(int id, String name, String email, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Marks: " + marks;
    }
}
