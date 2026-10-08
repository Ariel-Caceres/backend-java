import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Product teclado = new Product(1, "Teclado", 100, 1000);
        Product mouse = new Product(2, "Mouse", 100, 1000);
        products.add(teclado);
        products.add(mouse);
        System.out.println(products.size());

        teclado.changePrice(150);
        products.removeIf(product -> product.getId() == 2);
        for (Product product : products) {
            if (product.getId() == 2) {
                product.changePrice(200);
            }
            product.showInfo();
        }
    }
}