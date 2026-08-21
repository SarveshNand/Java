package ArraysConstructorsThisSuperAndOOP;

public class Student extends User{
    String courseName;

    Student(String name, String email, String courseName) {
        super(name, email);
        this.courseName = courseName;
    }

    @Override
    void showProfile() {
        super.showProfile();
        System.out.println("Course: " + courseName);
    }
}
