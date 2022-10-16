package se.iths.labbar.labbtwo;

import java.util.Objects;

public class Product {

    private final String category;
    private final String name;
    private final double price;
    private final String brand;
    private final String productId;
    private final int stock;

    public Product(String productId, String category, String name, double price,
                   String brand, int stock) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.productId = productId;
        this.stock = stock;
    }


    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return price == that.price && stock == that.stock && Objects.equals(category, that.category) && Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price, brand, productId, stock);
    }

    @Override
    public String toString() {
        return "[ID]: " + productId +
                " [Category]: " + category +
                " [Name]: " + name +
                " [Price]: " + price +
                " [Brand]: " + brand +
                " [Stock]: " + stock +
                " left";
    }
}

