import java.util.Scanner;

public class P5 {
    public static double calculateAverage(int num1, int num2) {
        return (num1 + num2) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the two integers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println("Average: " + calculateAverage(num1, num2));
    }
}
