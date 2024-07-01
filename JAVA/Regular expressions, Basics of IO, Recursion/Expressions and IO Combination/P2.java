import java.util.Scanner;

public class P2 {
    public static double calculateCompoundInterest(double principal, double rate, double time) {
        int n = 12;
        rate = rate / 100.0;
        return principal * Math.pow((1 + rate / n), (n * time));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");
        double rate = sc.nextDouble();

        System.out.print("Enter the time in years: ");
        double time = sc.nextDouble();

        System.out.printf("The compound interest is: %.2f%n", calculateCompoundInterest(principal, rate, time));
    }
}
