package JavaExceptionHandling;

public class ProductServiceExtended{
    void getProductById(int productId){
        if (productId<=0){
            throw new InvalidProductIdException("Product ID must be greater than 0");
        }
        if (productId != 101){
            throw new ProductNotFoundException("Product with ID " + productId + " was not found");
        }
        System.out.println("Product ID: 101");
        System.out.println("Product Name: Laptop");
        System.out.println("Price: ₹50,000");
    }
}
