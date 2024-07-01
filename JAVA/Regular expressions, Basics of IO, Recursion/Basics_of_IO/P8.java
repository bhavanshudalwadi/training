package Basics_of_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P8 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Basics_of_IO\\P8.txt");
        fw.write("Bhavanshu Dalwadi");
        fw.close();

        File file = new File("Basics_of_IO\\P8.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

}
