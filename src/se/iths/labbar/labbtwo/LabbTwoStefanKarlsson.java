package se.iths.labbar.labbtwo;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import static se.iths.labbar.labbtwo.CsvReader;

public class LabbTwoStefanKarlsson {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.runMenu();

    }
    private void runMenu() {
        CsvReader.csvProductList();
        String choice;
        do {
            printMenu();
            choice = scanner.nextLine();
        } while (menuChoice(choice));
        CsvReader.saveFile();
    }

    private void printMenu() {
        System.out.println("Welcome!");
        System.out.println("1.PRODUCTS");
        System.out.println("2.SEARCH");
        System.out.println("3.SEARCH PRICEINTERVAL");
        System.out.println("4.ADD NEW PRODUCT");
        System.out.println("5.REMOVE A PRODUCT");
        System.out.println("e.EXIT SHOP");
        System.out.print("");
    }

    private boolean menuChoice(String choice) {
        boolean continueApplication = true;
        switch (choice) {
            case "1" -> TobaccoProductService.getProducts().forEach(System.out::println);
            case "2" -> search();
            case "3" -> searchPrice();
            case "4" -> addNewProduct();
            case "5" -> removeProduct();
            case "e", "E" -> continueApplication = false;
            default -> System.out.println("Wrong input");
        }
        return continueApplication;
    }
    private void search() {
        String input;
        System.out.print("SÖK: ");
        input = scanner.nextLine().toUpperCase(Locale.ROOT);
        TobaccoProductService.findProduct(products, input);
    }

    private void searchPrice() {
        System.out.println("MINIMUM PRIS");
        int lowestPrice = scanner.nextInt();
        System.out.println("MAXIMUM PRIS");
        int highestPrice = scanner.nextInt();
        TobaccoProductService.findPrice(lowestPrice,highestPrice);
    }







}
