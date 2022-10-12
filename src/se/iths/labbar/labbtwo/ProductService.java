package se.iths.labbar.labbtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    static Scanner scanner = new Scanner(System.in);

    private static List<Product> productList = new ArrayList<>(getProduct());

    private static List<Product> getProduct () {
        return List.of(
                new Product(new Category("INSTALLATIONSMATERIEL"), "VÄGUTTAG 1-V", 197, "SCHNEIDER", "00001", 50),
                new Product(new Category("LAN-PRODUKTER"), "MODULARJACK KAT6", 54, "EXCEL", "00002", 45),
                new Product(new Category("BELYSNING"), "SPOT MINI", 620, "HIDE-A-LITE", "00003", 20));
    }
    public static void printProducts(){
        System.out.println("PRODUCTS");
        System.out.println("--------------");
        productList.stream()
                .map(Product::toString)
                .sorted()
                .forEach(System.out::println);

        LabbTwoStefanKarlssonV2.backToMenu();
    }
    public static void printProductByCategory(){

        System.out.println("Search Category:");
        String userSerach = scanner.nextLine().toUpperCase();

        ProductService.productList.stream()
                .filter(product ->product.getCategory().getCategoryName().equals(userSerach))
                .forEach(System.out::println);

    }
    public static void handleProductStock(){
        balanceMenu();
        System.out.println("Choose product and press \"ENTER\":");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        if(userInput != 0) {
            balanceSwitch(userInput);
            balanceMenu();
        }

    }
    private static void balanceSwitch(int userInput) {
        switch (userInput) {
            case 1:
                System.out.println("1: " + productList.get(0).getName() +
                        " " + productList.get(0).getBalance() + "pcs");
                newStorageAmount(userInput);
                break;
            case 2:
                System.out.println("2: " + productList.get(1).getName() +
                        " " + productList.get(1).getBalance() + "pcs");
                newStorageAmount(userInput);
                break;
            case 3:
                System.out.println("3: " + productList.get(2).getName() +
                        " " + productList.get(2).getBalance() + "pcs");
                newStorageAmount(userInput);
                break;
            case 4:
                System.out.println("4: " + productList.get(3).getName() +
                        " " + productList.get(3).getBalance() + "pcs");
                newStorageAmount(userInput);
                break;
            case 0:
                break;
            default:
                System.out.println("Not a valid input");
                handleProductStock();
                break;
        }
    }
    public static void balanceMenu() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.print("\n" + (i + 1) + ":\t");
            System.out.print(productList.get(i).getName() + ": "
                    + productList.get(i).getBalance() +"pcs");
        }
        System.out.println("\n0:  Back to Main Menu");
        System.out.println("");
    }
    public static void newStorageAmount(int userInput) {  //TODO Input crashar med bokstav
        System.out.print("Enter amount:");
        productList.get(userInput - 1).setBalance(scanner.nextInt());
        handleProductStock();
    }
}
