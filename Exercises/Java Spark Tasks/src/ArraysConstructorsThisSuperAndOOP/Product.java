package ArraysConstructorsThisSuperAndOOP;

public class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double calculateTotal() {
        return price * quantity;
    }

    void showBill() {
        System.out.println(name + " = " + calculateTotal());
    }
}
