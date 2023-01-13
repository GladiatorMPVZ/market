package api;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> items;
    private BigDecimal totalPrice;

    public CartDto(List<CartItemDto> items, BigDecimal totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public CartDto() {
    }
}