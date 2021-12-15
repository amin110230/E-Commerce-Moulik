package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.OrderDetailsDTO;
import net.moulik.ecommercemoulik.dto.OrderDetailsUpdateDTO;
import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.service.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("orders/users/{id}")
    public List<OrderDetailsDTO> getOrdersByUserId(@PathVariable("user_id") UUID userId) {
        return null; // need clarification
    }

    @PostMapping("orders")
    public void newProduct(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        orderDetailsService.createOrderDetails(orderDetailsDTO);
    }

    @PutMapping("orders/{order_id}")
    public void updateOrderDetails(@RequestBody OrderDetailsUpdateDTO orderDetailsUpdateDTO, @PathVariable("order_id") UUID orderId) {
        orderDetailsService.updateOrderDetails(orderDetailsUpdateDTO, orderId);
    }

    @DeleteMapping("orders/{order_id}")
    public void deleteOrderDetails(@PathVariable("order_id") UUID orderId) {
        orderDetailsService.deleteOrderDetails(orderId);
    }

}
