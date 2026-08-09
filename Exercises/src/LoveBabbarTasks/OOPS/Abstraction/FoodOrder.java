package LoveBabbarTasks.OOPS.Abstraction;

class FoodOrder extends Order{
    String restaurantName;

    FoodOrder(int orderId, double amount, String restaurantName){
        super(orderId, amount);
        this.restaurantName = restaurantName;
    }

    @Override
    void calculateDeliveryTime(){
        System.out.println("Food delivery: 30 minutes");
    }

    void addFoodItem(){
        System.out.println("Food item added");
    }
}
