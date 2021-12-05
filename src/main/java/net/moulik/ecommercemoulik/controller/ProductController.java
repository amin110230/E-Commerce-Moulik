package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/api/products")
    public List<ProductDTO> getProducts() {
        return service.getProducts();
    }
}
