package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, UUID> {
}
