package customer.classes;

/**
 * Represents a customer with id and name.
 */
public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s",id,name);
    }
}
