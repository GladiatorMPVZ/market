package shopcore.integrations;

import api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    public Optional<CartDto> getCart() {
        return Optional.ofNullable(restTemplate.getForObject("http://localhost:8289/api/v1/cart/", CartDto.class));
    }

    public void clear() {
        restTemplate.getForObject("http://localhost:8289/api/v1/cart/clear", CartDto.class);
    }

}
