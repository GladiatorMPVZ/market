package shopcart.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shopcart.model.Cart;
import shopcart.service.CartService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }
    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }
    @GetMapping("/price_change")
    public void changeQuantity(@RequestParam Long productId, @RequestParam Integer delta) {
        cartService.changeQuantity(productId, delta);
    }
    @GetMapping("/delete/{productId}")
    public void deleteFromCart(@PathVariable Long productId) {
        cartService.deleteFromCart(productId);
    }
    @GetMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }
}
