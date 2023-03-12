package shopcore.controller;

import api.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import shopcore.entity.Product;
import shopcore.repository.ProductRepository;
import shopcore.services.ProductService;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ProductControllerTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ProductService productService;

    @Test
    void getProductById() {
        Product product = productService.create(
                ProductDto.newBuilder()
                        .withId(1L)
                        .withTitle("title")
                        .withPrice(new BigDecimal("100"))
                        .build());
        productRepository.save(product);

        Product productByHttp = webTestClient.get()
                .uri("/api/v1/products/" + product.getId())
                .exchange()
                .expectBody(Product.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(product.getId(), productByHttp.getId());
        Assertions.assertEquals(product.getTitle(), productByHttp.getTitle());
    }
}