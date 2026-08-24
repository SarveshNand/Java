package JavaExceptionHandling;

public class ProductService {
    static void findProduct(int productId){
        if (productId != 101){
            throw new ProductNotFoundException("Product with ID " + productId + " not found");
        } else {
            System.out.println("Product found");
        }
    }

    public static void main(String[] args) {
        try {
            findProduct(105);
        } catch (ProductNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
