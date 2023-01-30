package shopcart.convertors;

import api.CartItemDto;
import org.springframework.stereotype.Component;
import shopcart.model.CartItem;

@Component
public class CartItemConvertor {
    public CartItemDto entityToDto (CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setPrice(cartItem.getPrice());
        cartItemDto.setProductId(cartItem.getProdictId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        return cartItemDto;
    }
}
