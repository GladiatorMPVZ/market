package api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long productId;
    private String productTitle;
    private int quantity;
    private BigDecimal price;

    public CartItemDto(Long productId, String productTitle, int quantity, BigDecimal price) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.quantity = quantity;
        this.price = price;
    }

    public CartItemDto() {
    }
}