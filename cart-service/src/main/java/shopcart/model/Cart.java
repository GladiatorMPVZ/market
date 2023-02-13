package shopcart.model;

import api.ProductDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Component
public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(ProductDto product) {
        for (CartItem item : items) {
            if (product.getId().equals(item.getProdictId())) {
                item.changeQuantity(1);
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), product.getPrice(), 1));
    }



    public void delete(Long productId) {
        items.removeIf(item -> item.getProdictId().equals(productId));
    }

    public void changeQuantity(Long productId, Integer delta) {
        for (CartItem item : items) {
            if (item.getProdictId().equals(productId)) {
                if (item.getQuantity() == 0) {
                    items.remove(item);
                }
                item.changeQuantity(delta);
            }
        }
    }

    public void clearCart() {
        items.clear();
    }
}
