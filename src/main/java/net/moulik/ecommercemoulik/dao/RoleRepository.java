package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
