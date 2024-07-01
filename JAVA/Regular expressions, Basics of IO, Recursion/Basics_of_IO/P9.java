package Basics_of_IO;

import java.io.*;
import java.util.Scanner;

public class P9 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Basics_of_IO\\P8.csv");
        Scanner sc = new Scanner(file);

        sc.useDelimiter(",");

        while (sc.hasNext()) {
            System.out.print(sc.next());
        }
    }
}
