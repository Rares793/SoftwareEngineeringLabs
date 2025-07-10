package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private final List<Product> products = new ArrayList<>();
    private final Map<String, ActiveSession> sessions = new HashMap<>();

    public List<Product> getProducts() {
        return products;
    }
    public List<Product> getProductsSorted(Comparator<Product> criteria) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(criteria);
        return sorted;
    }
    void addSession(String username) {
        ActiveSession session = new ActiveSession(username);
        sessions.put(username, session);
    }
    void removeSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.remove(username);
        } else {
            System.out.println("Session not found: " + username);
        }
    }
    public void addToCart(String username, Product product, int quantity) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            session.addToCart(product, quantity);
            System.out.println("Cart items: " + session.getShoppingCart());
        } else {
            System.out.println("You need to be logged on in order to add to cart!");
        }
    }
    public void checkout(String username) {
        ActiveSession session = sessions.get(username);
        if (session != null) {
            System.out.println("You bought: " + session.getShoppingCart());
            session.deleteCart();
        } else {
            System.out.println("You need to be logged on in order to checkout!");
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Map<String, ActiveSession> getSessions() {
        return sessions;
    }
}
