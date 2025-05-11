package pl.gatomek.mapstruct.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Producer producer;
    private String code;
    private Status status;
    private Country origin;
    private NutriScore nutriScore;

    public Product(String name, BigDecimal price, String code, Status status, Country origin, NutriScore nutriScore, Producer producer) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.status = status;
        this.origin = origin;
        this.nutriScore = nutriScore;
        this.producer = producer;
    }

    public static Product of(String name, double price, String code, Status status, Country country, NutriScore nutriscore, Producer producer) {
        return new Product(name, BigDecimal.valueOf(price), code, status, country, nutriscore, producer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public NutriScore getNutriScore() {
        return nutriScore;
    }

    public void setNutriScore(NutriScore nutriScore) {
        this.nutriScore = nutriScore;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
