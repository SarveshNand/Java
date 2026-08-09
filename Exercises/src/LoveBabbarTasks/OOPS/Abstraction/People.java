package LoveBabbarTasks.OOPS.Abstraction;

enum BookingStatus {
    CONFIRMED,
    WAITLISTED,
    CANCELLED,
    COMPLETED
}

enum PaymentStat {
    PENDING,
    SUCCESS,
    FAILED,
    REFUNDED
}

enum SeatClass {
    ECONOMY,
    BUSINESS,
    FIRST
}

abstract class People {
    protected String name;
    protected int age;
    protected long phoneNumber;
    protected String email;

    People(String name, int age, long phoneNumber, String email){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    void login(){
        System.out.println(name + " logged in successfully");
    }

    void logout(){
        System.out.println(name + " logged out successfully");
    }

    void updateProfile(){
        System.out.println(name + " profile updated");
    }
}
