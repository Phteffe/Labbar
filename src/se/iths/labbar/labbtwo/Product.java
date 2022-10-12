package se.iths.labbar.labbtwo;

import java.util.Objects;

public class Product {
    private Category category;
    private String name;
    private int price;
    private String brand;
    private String productId;
    private int balance;

    public Product(Category category, String name, int price,
                   String label, String productId, int stock) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.brand = label;
        this.productId = productId;
        this.balance = stock;
    }


    public Category getCategory() {
        return category;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }



    public String getBrand() {
        return brand;
    }



    public String getProductId() {
        return productId;
    }


    public int getBalance() {
        return balance;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return price == that.price && balance == that.balance && Objects.equals(category, that.category) && Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price, brand, productId, balance);
    }

    @Override
    public String toString() {
        return "Category: " + category +
                ", Product name: " + name +
                ", Price: " + price + "kr"+
                ", Brand: " + brand +
                ", ID: " + productId +
                ", Balance: " + balance +
                "pcs";
    }
}
