import java.util.Scanner;

public class P4 {
    static float add(float a, float b) {
        return a + b;
    }

    static float subtract(float a, float b) {
        return a - b;
    }

    static float multiply(float a, float b) {
        return a * b;
    }

    static float divide(float a, float b) {
        return a / b;
    }

    static float exponent(float a, float b) {
        return (float) Math.pow(a, b);
    }

    public static void main(String[] args) {
        int choice;
        float a, b;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n1. ADD\n2. SUB\n3. MUL\n4. DIV\n5. EXP\nEnter your choice: ");
            choice = sc.nextInt();

            System.out.println("Enter two numbers: ");
            a = sc.nextFloat();
            b = sc.nextFloat();

            switch (choice) {
                case 1: System.out.print("Additon: " + add(a, b));
                        break;
                case 2: System.out.print("Substraction: " + subtract(a, b));
                        break;
                case 3: System.out.print("Multiplication: " + multiply(a, b));
                        break;
                case 4: System.out.print("Division: " + divide(a, b));
                        break;
                case 5: System.out.print("Exponentiation: " + exponent(a, b));
                        break;
                default:System.out.print("Invalid Choice");
                        break;
            }
        } while (choice > 0 && choice < 7);
    }
}
