package shopcore.services;

import api.CartDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopcore.entity.Order;
import shopcore.entity.OrderItem;
import shopcore.integrations.CartServiceIntegration;
import shopcore.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;
    private final OrderRepository orderRepository;

    @Transactional
    public void createOrder() {
        CartDto cart = cartServiceIntegration.getCart().get();
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Нельзя оформить заказ для пустой корзины");
        }
        Order order = new Order();
        order.setTotalPrice(cart.getTotalPrice());
        order.setItems(new ArrayList<>());
        cart.getItems().forEach(ci -> {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setPrice(ci.getPrice());
            oi.setQuantity(ci.getQuantity());
            oi.setProduct(productService.findProductById(ci.getProductId()));
            order.getItems().add(oi);
        });
        orderRepository.save(order);
        cartServiceIntegration.clear();
    }

    public List<Order> findUserOrders(String username) {
        return orderRepository.findAllByUsername(username);
    }
}
