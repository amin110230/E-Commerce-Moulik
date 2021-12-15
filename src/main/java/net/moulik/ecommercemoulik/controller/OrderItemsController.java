package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.service.OrderItemsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class OrderItemsController {
    private final OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }
}
