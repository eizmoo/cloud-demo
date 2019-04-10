package top.lajijson.serviceproduct.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Integer id;

    private String name;

    private BigDecimal price;

    public Product() {
    }

    public Product(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
