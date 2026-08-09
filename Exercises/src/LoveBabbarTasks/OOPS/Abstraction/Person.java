package LoveBabbarTasks.OOPS.Abstraction;

abstract class Person {
    String name;
    long phone;

    Person(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }

    void login() {
        System.out.println(name + " logged in");
    }

    void logout() {
        System.out.println(name + " logged out");
    }
}
