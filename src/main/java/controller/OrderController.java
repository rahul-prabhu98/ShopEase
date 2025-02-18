package controller;

import ch.qos.logback.core.model.Model;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.OrderService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;


}
