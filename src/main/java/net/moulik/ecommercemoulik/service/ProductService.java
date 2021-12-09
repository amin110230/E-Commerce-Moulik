package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.ProductRepository;
import net.moulik.ecommercemoulik.dto.ProductDTO;
import net.moulik.ecommercemoulik.dto.ProductUpdateDTO;
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
            ProductDTO productDTO = getProductDTO(product);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    private ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCode(product.getCode());
        productDTO.setSize(product.getSize());
        productDTO.setSku(product.getSku());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public ProductDTO getProductById(UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            Product p = product.get();
            ProductDTO productDTO = getProductDTO(p);
            return productDTO;
        }
        return null;

    }

    public void createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCode(productDTO.getCode());
        product.setSize(productDTO.getSize());
        product.setSku(productDTO.getSku());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
    }

    public void updateProduct(ProductUpdateDTO productUpdateDTO, UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product p = product.get();
            p.setId(productUpdateDTO.getId());
            p.setName(productUpdateDTO.getName());
            p.setDescription(productUpdateDTO.getDescription());
            p.setCode(productUpdateDTO.getCode());
            p.setSize(productUpdateDTO.getSize());
            p.setSku(productUpdateDTO.getSku());
            p.setPrice(productUpdateDTO.getPrice());
            productRepository.save(p);
        }
    }

    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

    public void searchProduct() {
//        productRepository.findById();
    }
}
