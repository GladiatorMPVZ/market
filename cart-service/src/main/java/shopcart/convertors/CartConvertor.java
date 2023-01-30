package shopcart.convertors;

import api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shopcart.model.Cart;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConvertor {
    private final CartItemConvertor cartItemConvertor;

    public CartDto entityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setItems(cart.getItems().stream().map(cartItemConvertor::entityToDto).collect(Collectors.toList()));
        return cartDto;
    }
}