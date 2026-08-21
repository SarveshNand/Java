package ArraysConstructorsThisSuperAndOOP;

public class Course {
    String courseName;
    int duration;
    double fees;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
        this.fees = 15000;
    }

    Course(String courseName, int duration, double fees) {
        this(courseName, duration);
        this.fees = fees;
    }

    void display() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fees: " + fees);
    }
}
