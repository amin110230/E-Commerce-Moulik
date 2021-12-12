package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, UUID> {
    List<OrderDetails> getOrderDetailsByStatus(String orderStatus);
}
