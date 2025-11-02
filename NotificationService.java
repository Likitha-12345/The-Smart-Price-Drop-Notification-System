package ecommerce.service;

import ecommerce.user.User;
import ecommerce.model.Product;

public interface NotificationService {
	void sendNotification(User user, Product product, String message);
}
