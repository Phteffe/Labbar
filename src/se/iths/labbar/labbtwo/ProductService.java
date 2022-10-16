package se.iths.labbar.labbtwo;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import static se.iths.labbar.labbtwo.CSVReader.productList;

public class ProductService {

    static Scanner scanner = new Scanner(System.in);


    public static void printProducts() {
        System.out.println("PRODUCTS");
        System.out.println("--------------");
        productList.stream()
                .map(Product::toString)
                .sorted()
                .forEach(System.out::println);

        backToMenu();
    }

    public static void createNewProduct() {
        String category, name, brand, productId;
        int stock, price;

        try {
            System.out.println("Enter Product category: ");
            category = scanner.nextLine().toUpperCase();
            System.out.println("Enter product name");
            name = scanner.nextLine().toUpperCase();
            System.out.println("Enter brand");
            brand = scanner.nextLine().toUpperCase();
            System.out.println("Enter product ID");
            productId = scanner.nextLine();
            System.out.println("Enter Price");
            price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter amount in stock");
            stock = scanner.nextInt();
            scanner.nextLine();

            CSVReader.productList.add(new Product(productId, category, name, price, brand, stock));

            backToMenu();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void searchProduct() {

        System.out.println("Search Category or Product:");
        String userSearch = scanner.nextLine().toUpperCase();

        System.out.println("RESULT:");
        productList.stream()
                .filter(product -> product.getCategory().contains(userSearch) || product.getName().contains(userSearch))
                .forEach(System.out::println);

        backToMenu();

    }

    public static void searchProductByPrice() {

        try {
            System.out.println("Enter Min Price for product:");
            int minPriceInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Max Price for product");
            int maxPriceInput = scanner.nextInt();
            scanner.nextLine();

            System.out.println("RESULT:");
            productList.stream()
                    .filter(price -> price.getPrice() >= minPriceInput && price.getPrice() <= maxPriceInput)
                    .sorted(Comparator.comparing(Product::getPrice))
                    .forEach(System.out::println);

            backToMenu();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    public static void printProductName() {
        System.out.println("-----Products-----");
        productList.stream()
                .map(Product::getName)
                .sorted()
                .forEach(System.out::println);

    }

    public static void removeProduct() {
        printProductName();
        System.out.println("Choose a product to remove by typing it below: ");
        String userInput = scanner.nextLine().toUpperCase();

        try {
            Product removeAProduct = productList.stream()
                    .filter(product -> product.getName().equals(userInput))
                    .reduce((first, second) -> second).get();

            productList.remove(removeAProduct);

            System.out.println(userInput + " is Successfully removed!");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }


    public static void backToMenu() {
        System.out.println("Press \"ENTER\" to return");
        scanner.nextLine();
    }

}
