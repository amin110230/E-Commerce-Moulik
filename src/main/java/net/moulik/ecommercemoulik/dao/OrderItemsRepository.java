package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemsRepository extends JpaRepository<OrderItems, UUID> {
}
