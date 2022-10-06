package se.iths.labbar.labbtwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {
    private static Pattern pattern = Pattern.compile(",");
    static Path csvPath = Path.of("resources", "products.csv");
    static List<Product> products = new ArrayList<>();

    protected static void csvProductList() {
        try (Stream<String> lines = Files.lines(csvPath)) {
            products = lines.skip(2)
                    .map(CsvReader::createProducts)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void csvRow(Product product, List<String> strings) {
        strings.add(String.join(",", product.getItemNumber(), product.getName(),
                product.getBrand(),
                product.getCategory(),
                String.valueOf(product.getPrice()),
                String.valueOf(product.getBalance())));
    }
    protected static Product createProducts(String line) {
        String[] arr = pattern.split(line);

        return new Product(arr[0], arr[1], arr[2], arr[3], Double.parseDouble(arr[4]), Integer.parseInt(arr[5]));
    }

    protected static void saveFile() {
        List<String> strings = new ArrayList<>();
        strings.add("#Produkter");
        strings.add("itemNumber, name, brand, category, price, balance");
        ProductService.getProducts().forEach(product -> csvRow(product, strings));
        if (!Files.exists(csvPath)) {
            return;
        }
        try {
            Files.write(csvPath, strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
