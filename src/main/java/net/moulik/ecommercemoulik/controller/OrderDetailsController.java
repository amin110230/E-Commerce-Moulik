package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.OrderDetailsDTO;
import net.moulik.ecommercemoulik.dto.OrderDetailsUpdateDTO;
import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.dto.ResponseModel;
import net.moulik.ecommercemoulik.service.OrderDetailsService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseModel> getOrders () {
        ResponseModel model = new ResponseModel();
        model.setMessage("");
        model.setData(orderDetailsService.getOrders());
        return ResponseEntity.ok(model);
    }

    @GetMapping("orders/{order_id}")
    public ResponseEntity<ResponseModel> getOrderById (@PathVariable("order_id") UUID orderId) {
        ResponseModel model = new ResponseModel();
        model.setMessage("");
        model.setData(orderDetailsService.getOrderById(orderId));
        return ResponseEntity.ok(model);
    }

    @GetMapping("orders/{order_status}")
    public ResponseEntity<ResponseModel> getOrderByStatus(@PathVariable("order_status") String orderStatus) {
        ResponseModel model = new ResponseModel();
        model.setMessage("");
        model.setData(orderDetailsService.getOrderByStatus(orderStatus));
        return ResponseEntity.ok(model);
    }

    @GetMapping("orders/users/{user_id}")
    public ResponseEntity<ResponseModel> getOrdersByUserId(@PathVariable("user_id") UUID userId) {
        return null; // need clarification
    }

    @PostMapping("orders")
    public ResponseEntity<ResponseModel> newProduct(@RequestBody OrderDetailsDTO orderDetailsDTO){
        orderDetailsService.createOrderDetails(orderDetailsDTO);
    }

    @PutMapping("orders/{order_id}")
    public ResponseEntity<ResponseModel> updateOrderDetails(@RequestBody OrderDetailsUpdateDTO orderDetailsUpdateDTO, @PathVariable("order_id") UUID orderId) {
        orderDetailsService.updateOrderDetails(orderDetailsUpdateDTO, orderId);
    }

    @DeleteMapping("orders/{order_id}")
    public ResponseEntity<ResponseModel> deleteOrderDetails(@PathVariable("order_id") UUID orderId) {
        orderDetailsService.deleteOrderDetails(orderId);
    }

}
