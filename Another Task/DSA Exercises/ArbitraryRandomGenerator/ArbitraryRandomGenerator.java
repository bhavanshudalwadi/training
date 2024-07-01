package ArbitraryRandomGenerator;

import java.util.Random;

public class ArbitraryRandomGenerator {
    private Random rand;

    public ArbitraryRandomGenerator() {
        rand = new Random();
    }

    public double generateRandom() {
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        ArbitraryRandomGenerator randomGenerator = new ArbitraryRandomGenerator();

        // Example usage
        double randomNumber = randomGenerator.generateRandom();
        System.out.println("Random number: " + randomNumber);
    }
}
