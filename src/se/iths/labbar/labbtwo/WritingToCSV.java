package se.iths.labbar.labbtwo;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WritingToCSV {
    public static void main(String[] args) {

        int productID;
        String name;
        String brand;
        String category;
        int price;
        int stock;
        String filepath = "products.txt";


        saveRecord(1,"General","Swedish Match","snus",45,25,"products.txt");
        saveRecord(2,"Fjällen","Lundgrens","snus",49,33,"products.txt");
        saveRecord(3,"Skåne","Lundgrens","snus",48,7,"products.txt");
        saveRecord(4,"Marlboro red","Marlboro","cigarettes",68,13,"products.txt");
        saveRecord(5,"LM blå","L&M","cigarettes",59,87,"products.txt");
        saveRecord(6,"Gula Blend","Blend","cigarettes",53,29,"products.txt");


    }
    public static void saveRecord(int productID, String name, String brand, String category, int price, int stock, String filepath) {

        try {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(productID+","+name+","+brand+","+category+","+price+","+stock);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Record Saved");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Record not Saved");

        }
    }

}
