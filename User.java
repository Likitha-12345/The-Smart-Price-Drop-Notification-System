package ecommerce.user;

import java.util.ArrayList;
import ecommerce.model.Product;

public class User {
	private String name;
    private ArrayList<Product> bag = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addToBag(Product product) {
        bag.add(product);
        System.out.println("Added to bag: " + product.getName() +
                           " (ID: " + product.getProductId() + ")");
    }

    public ArrayList<Product> getBag() {
        return bag;
    }
}
