package shopcart.integrations;

import api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;

    public Optional<ProductDto> getProductDtoById(Long id) {
        return Optional.ofNullable(restTemplate.getForObject("http://localhost:8289/api/v1/products" + id, ProductDto.class));
    }
}
