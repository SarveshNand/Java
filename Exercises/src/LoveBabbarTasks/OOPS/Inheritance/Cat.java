package LoveBabbarTasks.OOPS.Inheritance;

public class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }

    public void meow(){
        System.out.println("Meow Meow");
    }
}
