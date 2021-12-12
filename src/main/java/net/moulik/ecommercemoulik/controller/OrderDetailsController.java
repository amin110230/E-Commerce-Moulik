package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.OrderDetailsDTO;
import net.moulik.ecommercemoulik.service.OrderDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("orders")
    public List<OrderDetailsDTO> getOrders () {
        return orderDetailsService.getOrders();
    }

    @GetMapping("orders/{order_id}")
    public OrderDetailsDTO getOrderById (@PathVariable("order_id") UUID orderId) {
        return orderDetailsService.getOrderById(orderId);
    }

    @GetMapping("orders/{order_status}")
    public List<OrderDetailsDTO> getOrderByStatus(@PathVariable("order_status") String orderStatus) {
        return orderDetailsService.getOrderByStatus(orderStatus);
    }


}
