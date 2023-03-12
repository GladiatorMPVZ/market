package api;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> items;
    private BigDecimal totalPrice;

    public CartDto(Builder builder) {
        items = builder.items;
        totalPrice = builder.totalPrice;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CartDto copy) {
        Builder builder = new Builder();
        builder.items = copy.getItems();
        builder.totalPrice = copy.totalPrice;
        return builder;
    }

    public static final class Builder {
        private List<CartItemDto> items;
        private BigDecimal totalPrice;

        private Builder() {
        }

        public Builder withItems(List<CartItemDto> val) {
            items = val;
            return this;
        }

        public Builder withTotalPrice(BigDecimal price) {
            totalPrice = price;
            return this;
        }

        public CartDto build() {
            return new CartDto(this);
        }


    }
}