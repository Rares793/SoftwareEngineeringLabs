package isp.lab6.exercise3;

public class User {
    private String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User)object;
        return username.equals(user.username) || password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return username.hashCode() + password.hashCode();
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
