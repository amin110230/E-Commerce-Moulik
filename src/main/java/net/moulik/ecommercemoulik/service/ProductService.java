package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.ProductRepository;
import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
}
