package ecommerce.controller;

import ecommerce.facades.EcommerceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecommerce")
public class EcommerceController {

    @Autowired
    private EcommerceFacade ecommerceFacade;

    @PostMapping("/processOrder")
    public String processOrder(@RequestParam String user, @RequestParam String password, @RequestParam String order) {
        boolean result = ecommerceFacade.processOrder(user, password, order);
        return result ? "Pedido processado com sucesso!" : "Falha ao processar o pedido.";
    }
}
