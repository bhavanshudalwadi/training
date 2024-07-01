package Exceptions;

public class P1 {
    public static void main(String[] args) {
        try {
            int a = 56, b = 0;
            double d = a / b;
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
