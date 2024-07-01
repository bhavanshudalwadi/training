package Recursion;

public class P8 {
    public static int sumOfNaturalNums(int n) {
        if(n == 0) {
            return n;
        }
        return n + sumOfNaturalNums(--n);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNums(10));
    }
}
