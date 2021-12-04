package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, UUID> {
}
