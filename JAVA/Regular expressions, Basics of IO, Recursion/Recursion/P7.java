package Recursion;

public class P7 {
    public static int gcd(int a, int b) {
        System.out.println(a+" "+b);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(105, 30));
    }
}