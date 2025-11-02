package ecommerce.service;

import ecommerce.user.User;
import ecommerce.model.Product;

public class EmailNotification implements NotificationService {
	 @Override
	    public void sendNotification(User user, Product product, String message) {
	        System.out.println("\nEmail Notification to " + user.getName() + ":");
	        System.out.println(message);
	    }

}
