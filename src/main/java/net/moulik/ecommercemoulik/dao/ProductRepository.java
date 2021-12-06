package net.moulik.ecommercemoulik.dao;

import net.moulik.ecommercemoulik.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
        //derived query
        List<Product> getProductsByProductCategoryId_Name(String categoryName);
}
