package org.example.chapter10.practice02.entity;

public class Electronics extends Item{

    private String brand;
    private int warranty;

    public Electronics(String id, String name, int price, int quantity, String brand, int warranty) {
        super(id, name, price, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public String toString() {
             // 부모가 재정의한 toString();
        return super.toString() + " // Brand: " + brand + ", Warranty: " + warranty;
    }
}
