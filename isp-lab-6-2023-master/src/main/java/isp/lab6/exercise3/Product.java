package isp.lab6.exercise3;

public class Product {
    public final String name;
    public final int price;

    public Product(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product)object;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "(" + name + " - " + price + " lei)";
    }
}
