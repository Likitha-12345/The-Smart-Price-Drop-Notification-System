package ecommerce.main;

import ecommerce.model.Product;
import ecommerce.user.User;
import ecommerce.service.*;

public class ECommerceNotificationDemo {

	public static void main(String[] args) {
		// Create user and products
        User user = new User("Aarav");

        Product p1 = new Product(101, "iPhone 14 Pro Max", 145000);
        Product p2 = new Product(102, "Sony WH-1000XM5 Headphones", 29990);
        Product p3 = new Product(103, "Apple Watch Series 9", 41999);

        // Add to user's bag
        user.addToBag(p1);
        user.addToBag(p3);
        user.addToBag(p2);

        // Create notification service
        NotificationService notifier = new EmailNotification();

        // Simulate price changes
        p1.updatePrice(140000, user, notifier); // ↓ decrease → notify
        p1.updatePrice(145000, user, notifier); // ↑ increase → no notification
        p3.updatePrice(40000, user, notifier);  // ↓ decrease → notify
        p3.updatePrice(40000, user, notifier);  // same → no notification
        p1.updatePrice(139000, user, notifier); // ↓ decrease → notify again
    }
}
