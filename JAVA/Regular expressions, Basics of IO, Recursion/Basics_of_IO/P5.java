package Basics_of_IO;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter line:");
        String s = sc.nextLine();
        System.out.println("length is :"+s.length());
    }
}
