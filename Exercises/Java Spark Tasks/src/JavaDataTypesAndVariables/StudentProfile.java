package JavaDataTypesAndVariables;

public class StudentProfile {
    static void main() {
        String studentName = "Pratiksha";
        int rollNumber = 67;
        String collegeName = "VBSPU";
        String courseName = "BCA";
        int semester = 6;
        int javaMarks = 60;
        int databaseMarks = 60;
        int webTechnologyMarks = 70;
        int totalMarks = javaMarks + databaseMarks + webTechnologyMarks;
        double percentage = totalMarks/3.0;
        char grade = 'D';
        boolean passStatus = true;

        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("College: " + collegeName);
        System.out.println("Course: " + courseName);
        System.out.println("Semester: " + semester);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Pass Status: " + passStatus);
    }
}
