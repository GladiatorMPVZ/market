package shopcore.services;

import api.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shopcore.entity.Product;
import shopcore.repository.ProductRepository;

import java.math.BigDecimal;
@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Test
    void createNewProduct() {
        Product product = productService.create(
                new ProductDto(2L, "test2", new BigDecimal("200"))
        );
        Assertions.assertNotNull(product);
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("test2", product.getTitle());

        Product productSave = productRepository.findById(product.getId()).orElse(null);
        Assertions.assertEquals(product.getTitle(), productSave.getTitle());
    }
}