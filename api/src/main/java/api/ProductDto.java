package api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;

    public ProductDto(Builder builder) {
        id = builder.id;
        title = builder.title;
        price = builder.price;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductDto copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.title = copy.getTitle();
        builder.price = copy.getPrice();
        return builder;
    }

    public static final class Builder {
        private Long id;
        private String title;
        private BigDecimal price;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }
        public ProductDto build() {
            return new ProductDto(this);
        }
    }
}