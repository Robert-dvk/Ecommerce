package ecommerce.facades;

import ecommerce.services.AuthService;
import ecommerce.services.PaymentService;
import ecommerce.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcommerceFacade {

    @Autowired
    private AuthService authService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InventoryService inventoryService;

    public boolean processOrder(String user, String password, String order) {
        if (authService.authenticate(user, password)) {
            if (inventoryService.checkInventory(order)) {
                paymentService.processPayment(user, order);
                inventoryService.updateInventory(order);
                return true;
            }
        }
        return false;
    }
}
