package br.edu.ifpb.domain;

import java.math.BigDecimal;

public class ProductNull extends Product {

    public String getTitle() {
        return "empty";
    }

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(0L);
    }

    public String getDesc() {
        return "Lorem Ipsum";
    }

    public ProductType getProductType() {
        return ProductType.GENERIC;
    }
}
