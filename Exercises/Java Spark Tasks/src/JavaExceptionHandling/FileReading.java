package JavaExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReading {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("student.txt");
            System.out.println("File opened successfully.");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check whether student.txt exists.");
        } catch (Exception e) {
            System.out.println("Unable to read the file.");
        }
    }
}
