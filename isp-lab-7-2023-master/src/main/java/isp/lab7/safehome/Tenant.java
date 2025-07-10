package isp.lab7.safehome;

public class Tenant {
    private final String name;
    public Tenant(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || getClass() != object.getClass()) {
            return false;
        }
        Tenant tenant = (Tenant) object;
        return name.equals(tenant.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
