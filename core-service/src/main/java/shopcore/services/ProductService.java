package shopcore.services;

import api.ProductDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shopcore.entity.Product;
import shopcore.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final IdentityMap identityMap;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        Product product = this.identityMap.getProductMap(id);
        if (product != null) {
            return product;
        } else {
            product = productRepository.findById(id).orElseThrow();
            if (product != null) {
                this.identityMap.addProductMap(product);
                return product;
            }
        }
        return null;
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
