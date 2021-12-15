package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.OrderItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }
}
