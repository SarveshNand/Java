package LoveBabbarTasks.OOPS.Intro;

public class Student {
//    Attributes
    public String name;
    public int rollNo;
    public int age;
//    Methods
    public Student(String name, int rollNo, int age){
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }
    public void displayDetails(){
        System.out.println("------------------------");
        System.out.println("Inside displayDetails()");
        System.out.println("------------------------");
        System.out.println("Your Name: " + " " + name);
        System.out.println("Your roll no.: " + " " + rollNo);
        System.out.println("Your age: " + " " + age);
    }
}
