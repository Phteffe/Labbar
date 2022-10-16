package se.iths.labbar.labbtwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader {
    private static final Pattern pattern = Pattern.compile(",");
    private static final Path csvPath = Path.of("src\\se\\iths\\labbar\\Labbtwo\\csvfile","productList.csv");
    static List<Product> productList = new ArrayList<>();

    protected static void csvProductList(){
        try(Stream<String> lines = Files.lines(csvPath)) {
            productList =lines.skip(1)
                    .map(CSVReader::createProduct)
                    .collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected static Product createProduct(String line){
        String[] product = pattern.split(line);

        return new Product(
                product[0],
                product[1],
                product[2],
                Double.parseDouble(product[3]),
                product[4],
                Integer.parseInt(product[5]));
    }
    protected static void csvRow(Product product, List<String> productList) {
        productList.add(String.join(",",
                String.valueOf(product.getProductId()),
                product.getCategory(),
                String.valueOf(product.getName()),
                String.valueOf(product.getPrice()),
                product.getBrand(),
                String.valueOf(product.getStock())));
    }
    public static void saveProduct(){
        List<String> products = new ArrayList<>();
        products.add("ID,Category,Name,Price,Brand,Stock");
        productList.forEach(product -> csvRow(product, products));

        try {
            Files.write(csvPath, products);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
