package JavaClassObjectsAndMethods;

public class Student {
    String name;
    int rollNumber;
    int age;
    double marks;
    int studentId;

    void displayDetails(){
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }

    String getResult(){
        if (marks>=40){
            return "Pass";
        } else {
            return "Fail";
        }
    }
}
