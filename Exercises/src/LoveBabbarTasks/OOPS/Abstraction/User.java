package LoveBabbarTasks.OOPS.Abstraction;

abstract class User {
    String name;
    long phone;

    User(String name, long phone){
        this.name = name;
        this.phone = phone;
    }

    void login(){
        System.out.println(name + " logged in");
    }

    void logout(){
        System.out.println(name + " logged out");
    }
}
