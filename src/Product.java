
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void showInfo() {
        System.out.println("Id:" + id);
        System.out.println("name:" + name);
        System.out.println("price:" + price);
        System.out.println("Stock:" + stock);
    }

    public void changePrice(double newPrice) {
        price = newPrice;
    }

    public int getId() {
        return id;
    }
}
