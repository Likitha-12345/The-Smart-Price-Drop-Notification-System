package ecommerce.model;

import ecommerce.user.User;
import ecommerce.service.NotificationService;

public class Product {
	 private int productId;
	    private String name;
	    private double previousPrice;
	    private double currentPrice;

	    public Product(int productId, String name, double price) {
	        this.productId = productId;
	        this.name = name;
	        this.currentPrice = price;
	        this.previousPrice = price;
	    }

	    public int getProductId() { return productId; }
	    public String getName() { return name; }
	    public double getCurrentPrice() { return currentPrice; }

	    // This method updates the price and triggers notification only once if price decreases
	    public void updatePrice(double newPrice, User user, NotificationService notifier) {
	        if (newPrice < currentPrice) { // Price decreased
	            previousPrice = currentPrice;
	            currentPrice = newPrice;

	            double diff = previousPrice - currentPrice;

	            // Send notification only once at the time of change
	            String message = "Product ID: " + productId + " | " + name +
	                    " — Price dropped by ₹" + diff +
	                    " (₹" + previousPrice + " → ₹" + currentPrice + ")";
	            notifier.sendNotification(user, this, message);
	        } else {
	            // Price increased or same, just update silently
	            previousPrice = currentPrice;
	            currentPrice = newPrice;
	        }
	    }

}
