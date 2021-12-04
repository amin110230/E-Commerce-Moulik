package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
}
