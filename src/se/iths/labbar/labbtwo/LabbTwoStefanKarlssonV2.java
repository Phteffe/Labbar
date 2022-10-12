package se.iths.labbar.labbtwo;

import java.util.Scanner;

public class LabbTwoStefanKarlssonV2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runProgram();


    }

    public static void runProgram() {
        boolean runMenu = true;

        while (runMenu) {
            menuOne();
            char menuOneInput = scanner.next().charAt(0);
            scanner.nextLine();

            switch (menuOneInput) {
                case '1':
                    CategoryService.listCategories();
                    backToMenu();
                    break;
                case '2':
                    CategoryService.createNewCategory();
                    break;
                case '3':
                    ProductService.printProducts();
                    backToMenu();
                case '4':
                    System.out.println("Manage balance");
                    break;
                case '5':
                    System.out.println("Search");
                case 'e', 'E':
                    runMenu = false;
                    System.out.println("Closing Program");
                    break;
                default:
                    System.out.println("Enter a valid input");
            }
        }
    }

    public static void backToMenu() {
        System.out.println("Press \"ENTER\" to return");
        scanner.nextLine();
    }

    private static void menuOne() {
        String menu = """
                Welcome to the warehouse:
                1.Browse categories
                2.Create new category
                3.Show products
                4.Stock management
                5.Search
                E.End program.""";
        System.out.println(menu);
    }
}
