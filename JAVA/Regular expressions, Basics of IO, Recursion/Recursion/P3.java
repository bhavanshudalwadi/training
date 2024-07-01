package Recursion;

public class P3 {
    static int sumOfDigit(int n) {
        System.out.println(n+" => "+n % 10);
        if (n == 0)
            return 0;
        return (n % 10 + sumOfDigit(n / 10));
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigit(482));
    }
}
