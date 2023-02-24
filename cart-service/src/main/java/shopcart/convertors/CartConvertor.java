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
        return CartDto.newBuilder()
                .withItems(cart.getItems().stream().map(cartItemConvertor::entityToDto).collect(Collectors.toList()))
                .build();
    }
}