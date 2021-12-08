package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.ProductRepository;
import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return getProductDTOS(products);
    }

    public List<ProductDTO> getProductsByCategory(String categoryName) {
        List<Product> products = productRepository.getProductsByProductCategoryId_Name(categoryName);
        return getProductDTOS(products);
    }

    private List<ProductDTO> getProductDTOS(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public ProductDTO getProductById(UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            Product p = product.get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(p.getName());
            return productDTO;
        }
        return null;

    }
}
