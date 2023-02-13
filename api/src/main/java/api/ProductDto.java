package api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;

    public ProductDto(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public ProductDto() {
    }
}