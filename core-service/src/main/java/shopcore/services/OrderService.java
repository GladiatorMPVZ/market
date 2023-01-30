package shopcore.services;

import api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopcore.entity.Order;
import shopcore.entity.OrderItem;
import shopcore.entity.User;
import shopcore.integrations.CartServiceIntegration;
import shopcore.repository.OrderRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderRepository orderRepository;


    public void createOrder(User user) {
        CartDto cartDto = cartServiceIntegration.getCart().orElseThrow();
        Order order = new Order();
        order.setItems(cartDto.getItems().stream().map(
                cartItem -> new OrderItem(
                        null,
                        productService.findProductById(cartItem.getProductId()),
                        order,
                        cartItem.getQuantity()
                )
        ).collect(Collectors.toList()));
        orderRepository.save(order);
        cartServiceIntegration.clear();
    }
}
