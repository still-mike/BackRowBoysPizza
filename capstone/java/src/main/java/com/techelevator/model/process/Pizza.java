package com.techelevator.model.process;

import java.math.BigDecimal;

public class Pizza {

    private int id;

    private String pizzaSize;

    private String dough;

    private String shape;

    private String sauceType;

    private String description;

    private BigDecimal pizzaPrice;

    private boolean isSpecialty;

    private int orderId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSauceType() {
        return sauceType;
    }

    public void setSauceType(String sauceType) {
        this.sauceType = sauceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(BigDecimal pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public boolean getIsSpecialty() {
        return isSpecialty;
    }

    public void setIsSpecialty(boolean specialty) {
        isSpecialty = specialty;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
