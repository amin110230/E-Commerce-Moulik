package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
