package LoveBabbarTasks.OOPS.Encapsulation;

public class ECommerceProduct {
    private String productName;
    private double price;
    private int stock;

    public ECommerceProduct(String productName, double price, int stock){
        this.productName = productName;
        this.price = Math.max(price, 0);
        this.stock = Math.max(stock, 0);
    }

    public void buy(int quantity){
        if (quantity <= 0){
            System.out.println("Invalid quantity.");
            return;
        }
        if (quantity > stock) {
            System.out.println("Can't buy more than available stock.");
            return;
        }
        stock -= quantity;
    }

    public void restock(int quantity){
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }
        stock += quantity;
    }

    public void changePrice(double changedValue){
        if (changedValue < 0) {
            System.out.println("Price can't be negative.");
            return;
        }
        price = changedValue;
    }

    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
}
