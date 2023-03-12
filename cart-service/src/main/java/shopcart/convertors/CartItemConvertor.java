package shopcart.convertors;

import api.CartItemDto;
import org.springframework.stereotype.Component;
import shopcart.model.CartItem;

@Component
public class CartItemConvertor {
    public CartItemDto entityToDto (CartItem cartItem) {
        return CartItemDto.newBuilder()
                .withPrice(cartItem.getPrice())
                .withProductId(cartItem.getProdictId())
                .withProductTitle(cartItem.getProductTitle())
                .withQuantity(cartItem.getQuantity())
                .build();
    }
}
