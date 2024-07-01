class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Overloading the "+" operator for complex numbers
    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    // toString method for better representation
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class One {
    public static void main(String[] args) {
        // Creating two complex numbers
        ComplexNumber complex1 = new ComplexNumber(2, 3);
        ComplexNumber complex2 = new ComplexNumber(1, -2);

        // Adding two complex numbers using the overloaded "+" operator
        ComplexNumber result = complex1.add(complex2);

        // Displaying the result
        System.out.println("Complex Number 1: " + complex1);
        System.out.println("Complex Number 2: " + complex2);
        System.out.println("Sum of Complex Numbers: " + result);
    }
}
