package se.iths.labbar.labbtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService {
    static Scanner scanner = new Scanner(System.in);
    public static List<Category> categoryList = new ArrayList<>(getCategory());

    public static void createNewCategory() {
        System.out.println("Insert the name of the new category:");
        categoryList.add(new Category(scanner.nextLine().toUpperCase()));
    }
    public static void listCategories () {
        System.out.println(">Categories<");
        System.out.println("------------");
        categoryList.stream()
                .map(Category::category)
                .sorted()
                .forEach(System.out::println);

        LabbTwoStefanKarlssonV2.backToMenu();

    }

    private static List<Category> getCategory () {
        return List.of(
                new Category("INSTALLATIONSMATERIEL"),
                new Category("LAN-PRODUKTER"),
                new Category("BELYSNING"));
    }

}
