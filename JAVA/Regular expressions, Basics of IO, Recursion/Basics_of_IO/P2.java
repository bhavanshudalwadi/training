package Basics_of_IO;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("enter num :");
        double i = sc.nextDouble();

        double sq =  i*i;
        System.out.println("sqare is :"+sq);
    }
}
