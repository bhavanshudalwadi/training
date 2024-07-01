package Exceptions;

public class P5 {
    public static void main(String[] args) {
        try {
            int a = 56, b = 0;
            double d = a / b;
            System.out.println(d);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }    
}
