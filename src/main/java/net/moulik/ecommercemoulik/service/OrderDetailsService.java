package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.OrderDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }
}
