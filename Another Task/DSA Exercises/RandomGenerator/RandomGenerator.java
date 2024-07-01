package dsaPrograms.RandomGenerator;

public class RandomGenerator {
    private static int randomZeroOne() {
        return Math.random() < 0.5 ? 0 : 1;
    }

    private static int randomZeroSix() {
        int randomNumber;

        int dieRoll = 2 * randomZeroOne() + randomZeroOne();

        int threeSidedDieRoll = 4 * randomZeroOne() + 2 * randomZeroOne() + randomZeroOne();

        if (threeSidedDieRoll < 3) {
            randomNumber = dieRoll;
        } else {
            randomNumber = threeSidedDieRoll;
        }

        return randomNumber;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(randomZeroSix());
        }
    }
}
