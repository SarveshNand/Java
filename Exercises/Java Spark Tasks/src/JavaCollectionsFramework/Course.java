package JavaCollectionsFramework;

import java.util.ArrayList;

public class Course {
    int id;
    String name;
    ArrayList<StudentCourse> students;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
    }

    void addStudent(StudentCourse student){
        students.add(student);
    }
}
