package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.dto.ProductSearchDTO;
import net.moulik.ecommercemoulik.dto.ProductUpdateDTO;
import net.moulik.ecommercemoulik.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping("products")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("productsByCategory")
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("products/{product_id}")
    public ProductDTO getProductById(@PathVariable("product_id") UUID productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("products")
    public void newProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
    }

    @PutMapping("products/{product_id}")
    public void updateProduct(@RequestBody ProductUpdateDTO productUpdateDTO, @PathVariable("product_id")  UUID productId) {
        productService.updateProduct(productUpdateDTO, productId);
    }

    @PutMapping("products")
    public void updateProduct(@RequestBody ProductUpdateDTO updateDTO) {
//        productService.updateProduct(productId);
        /*another way to update product*/
    }

    @DeleteMapping("products/{product_id}")
    public void deleteProduct(@PathVariable("product_id") UUID productId) {
        productService.deleteProduct(productId);
    }

    @PostMapping("search")
    public void searchProduct(ProductSearchDTO searchDTO) {
        productService.searchProduct();
    }
}
