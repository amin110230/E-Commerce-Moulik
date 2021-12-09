package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("api/products")
    public void newProduct(@RequestBody ProductDTO productDTO) {
        productService.newProduct(productDTO);
    }

    @PutMapping("api/products/{product_id}")
    public void updateProduct(@PathVariable("product_id" +
            "") UUID productId) {
        productService.updateProduct(productId);
    }

    @PutMapping("api/products")
    public void updateProduct() {
//        productService.updateProduct(productId);
    }

    @DeleteMapping("api/products/{product_id}")
    public void deleteProduct(@PathVariable("product_id" +
            "") UUID productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping("api/search")
    public void searchProduct() {
        productService.searchProduct();
    }
}
