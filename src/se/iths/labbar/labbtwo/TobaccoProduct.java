package se.iths.labbar.labbtwo;

import java.util.Objects;

public class TobaccoProduct {
    private final String name;
    private final String brand;
    private final String category;
    private int price;
    private final int productID;
    private int stock;

    public TobaccoProduct(String name, String brand, String category, int price, int productID, int stock) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.productID = productID;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "TobaccoProduct{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", productID=" + productID +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TobaccoProduct that = (TobaccoProduct) o;
        return price == that.price && productID == that.productID && stock == that.stock && Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, category, price, productID, stock);
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
