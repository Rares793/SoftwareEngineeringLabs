package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private final String username;
    private final Map<Product, Integer> shoppingCart = new HashMap<>();

    public ActiveSession(String username) {
        this.username = username;
    }

    public void addToCart(Product product, int quantity) {
        shoppingCart.put(product, quantity);
    }
    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }
    public String getUsername() {
        return username;
    }
    public void deleteCart() {
        shoppingCart.clear();
    }
}
