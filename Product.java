package API;

public class Product {
    private String id;
    private String name;
    private String description;
    private Long price;
    private String total;

    public Product() {
    }

    public Product(Object name, Object description, Object price, Object total) {
        this.name = (String) name;
        this.description = (String) description;
        this.price = (Long) price;
        this.total = (String) total;
    }

    public Product(Object id, Object name, Object description, Object price, Object total) {
        this.id = (String) id;
        this.name = (String) name;
        this.description = (String) description;
        this.price = (Long) price;
        this.total = (String) total;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
