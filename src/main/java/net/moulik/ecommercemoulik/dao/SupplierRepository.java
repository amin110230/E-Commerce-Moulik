package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
