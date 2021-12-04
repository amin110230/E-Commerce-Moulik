package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
}
