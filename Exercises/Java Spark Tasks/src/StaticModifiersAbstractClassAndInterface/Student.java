package StaticModifiersAbstractClassAndInterface;

public class Student {
    String name;
    double marks;
    int rollNumber;
    static String instituteName = "ABC Institute";
    static int studentCount = 0;

    Student() {
        studentCount++;
    }

    static void showTotalStudents() {
        System.out.println("Total Students: " + studentCount);
    }

    void showDetails(){
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Institute: " + instituteName);
        System.out.println();
    }

    void showResult(){
        String result;
        if (marks >= 40){
            result = "Pass";
        } else {
            result = "Fail";
        }

        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Result: " + result);
    }
}
