package LoveBabbarTasks.OOPS.Intro;

public class FoodItem {
//    Attributes
    int itemId;
    String itemName;
    String restaurantName;
    double price;
    double rating;

//    Default Constructor
    public FoodItem(){
        itemId = 0;
        itemName = "Not Available";
        restaurantName = "Unknown";
        price = 0;
        rating = 0;
    }
//    Parameterized Constructor
    public FoodItem(int itemId, String itemName, String restaurantName, double price, double rating){
        this.itemId = itemId;
        this.itemName = itemName;
        this.restaurantName = restaurantName;
        this.price = price;
        this.rating = rating;
    }

    void display(){
        System.out.println("Item ID: " + this.itemId);
        System.out.println("Item Name: " + this.itemName);
        System.out.println("Restaurant: " + this.restaurantName);
        System.out.println("Price: ₹" + this.price);
        System.out.println("Rating: " + this.rating);
    }

    void isExpensive(){
        if (this.price > 300){
            System.out.println("Expensive Item");
        } else {
            System.out.println("Affordable Item");
        }
    }

    void isPopular(){
        if (this.rating >= 4.5){
            System.out.println("Highly Rated");
        } else {
            System.out.println("Average Rating");
        }
    }
}
