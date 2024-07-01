package Basics_of_IO;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter first line");
        String s = sc.nextLine();

        System.out.println("enter second line");
        String s1 = sc.nextLine();

        String s3 = s + s1;
        System.out.println("concatenated string is :" + s3);
    }
}
