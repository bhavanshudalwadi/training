package Exceptions;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            
            if(age < 0) {
                throw new Exception("Invalid Ege");
            }else{
                System.out.println("Ege Is Valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
