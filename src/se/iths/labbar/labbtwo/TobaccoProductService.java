package se.iths.labbar.labbtwo;

import java.util.Comparator;
import java.util.List;

public class TobaccoProductService {

    public static void findProduct(List<TobaccoProduct> list, String input) {
        list.stream()
                .filter(product -> product.getName().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getProductID().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getBrand().contains(input))
                .forEach(System.out::println);
        list.stream()
                .filter(product -> product.getCategory().contains(input))
                .forEach(System.out::println);
    }
    public static void findPrice(int lowestPrice, int highestPrice) {
        products.stream()
                .filter(product -> product.getPrice() > lowestPrice && product.getPrice() < highestPrice)
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }

    protected static List<TobaccoProduct> getProducts() {
        return List.copyOf();
    }


}
