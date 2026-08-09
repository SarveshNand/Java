package LoveBabbarTasks.OOPS.Abstraction;

class RestaurantOwner extends User{
    String restaurantName;

    RestaurantOwner(String name, long phone, String restaurantName){
        super(name, phone);
        this.restaurantName = restaurantName;
    }

    void addFoodItem(){
        System.out.println("Food item added");
    }

    void removeFoodItem(){
        System.out.println("Food item removed");
    }

    void updateMenu(){
        System.out.println("Menu updated");
    }
}
