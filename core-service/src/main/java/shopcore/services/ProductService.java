package shopcore.services;

import api.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopcore.entity.Product;
import shopcore.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product create(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        productRepository.save(product);
        return product;
    }
}
