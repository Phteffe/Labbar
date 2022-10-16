package se.iths.labbar.labbtwo;

import java.util.Scanner;

public class LabbTwoStefanKarlssonV2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CSVReader.csvProductList();
        runMenu();

    }
    public static void runMenu(){

        boolean runMenu = true;

        while (runMenu) {
            printMainMenu();
            char menuOneInput = scanner.next().charAt(0);
            scanner.nextLine();
            switch (menuOneInput) {
                case '1':
                    ProductService.printProducts();
                    break;
                case '2':
                    ProductService.createNewProduct();
                    break;
                case '3':
                    ProductService.searchProduct();
                    break;
                case '4':
                    ProductService.searchProductByPrice();
                    break;
                case '5':
                    ProductService.removeProduct();
                    break;
                case '6':
                    CSVReader.saveProduct();
                    break;
                case 'e','E':
                    CSVReader.saveProduct();
                    System.out.println("Closing & Saving");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid input");
            }

        }

    }

    private static void printMainMenu() {
        String mainMenu = """
                    --------Welcome--------
                    1. Browse Products
                    2. Add New Product
                    3. Search Category/Product
                    4. Search Product by price
                    5. Remove Product
                    6. Manage Inventory
                    e. Exit & Save Program""";
        System.out.println(mainMenu);
    }
}
