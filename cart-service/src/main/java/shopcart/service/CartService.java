package shopcart.service;

import api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopcart.integrations.ProductServiceIntegration;
import shopcart.model.Cart;

import javax.annotation.PostConstruct;
@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;
    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }
    public Cart getCurrentCart() {
        return tempCart;
    }
    public void add(Long productId) {
        ProductDto product = productServiceIntegration.getProductDtoById(productId).orElseThrow();
        tempCart.add(product);
    }
    public void clearCart() {
        tempCart.clearCart();
    }
    public void deleteFromCart(Long productId) {
        tempCart.delete(productId);
    }
    public void changeQuantity(Long productId, Integer delta) {
        tempCart.changeQuantity(productId, delta);
    }
}
