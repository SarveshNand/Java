package JavaExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    void readFile() throws FileNotFoundException {
        try (FileReader reader = new FileReader("student.txt")) {
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    public static void main(String[] args) {
        FileService fileService = new FileService();
        try {
            fileService.readFile();
        } catch (FileNotFoundException e){
            System.out.println("File not found: student.txt");
        }
    }
}
