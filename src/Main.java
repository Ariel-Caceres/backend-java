import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Product teclado = new Product(1, "Teclado", 100, 1000);
        Product mouse = new Product(1, "Mouse", 100, 1000);
        products.add(teclado);
        products.add(mouse);
        System.out.println(products.size());

        for (Product product : products) {
            System.out.println(product.name);
        }
    }
}