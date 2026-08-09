package LoveBabbarTasks.OOPS.Abstraction;

public class Admin extends User{
    int adminId;

    Admin(String name, long phone, int adminId){
        super(name, phone);
        this.adminId = adminId;
    }

    void manageUsers(){
        System.out.println("Managing users");
    }

    void manageOrders(){
        System.out.println("Managing orders");
    }

    void blockUsers(){
        System.out.println("User blocked");
    }
}
