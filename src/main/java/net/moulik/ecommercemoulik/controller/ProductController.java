package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping("/api/products")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("api/productsByCategory")
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("api/products/{product_id}")
    public ProductDTO getProductById(@PathVariable("product_id" +
            "") UUID productId) {
        return productService.getProductById(productId);
    }
}
