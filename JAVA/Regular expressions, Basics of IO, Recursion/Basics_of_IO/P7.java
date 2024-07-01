package Basics_of_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Basics_of_IO\\P8.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

}
