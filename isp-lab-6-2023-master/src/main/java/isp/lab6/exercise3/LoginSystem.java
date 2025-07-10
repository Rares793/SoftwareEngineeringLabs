package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private final Set<User> users = new HashSet<>();
    private OnlineStore store;

    public void register(String username, String password) {
        User user = new User(username, password);
        if (users.contains(user)) {
            System.out.println("Username already exists!");
            return;
        }
        users.add(user);
    }

    public boolean login(String username, String password) {
        System.out.println("Login attempt: " + username + " " + password);
        User user = new User(username, password);
        if (users.contains(user)) {
            store.addSession(username);
            return true;
        }
        return false;
    }

    public boolean logout(String username) {
        System.out.println("Logout attempt: " + username);
        if(store.getSessions().containsKey(username)) {
            store.removeSession(username);
            return true;
        }
        return false;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setStore(OnlineStore store) {
        this.store = store;
    }
}
