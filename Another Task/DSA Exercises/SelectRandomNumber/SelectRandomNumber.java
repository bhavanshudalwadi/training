package dsaPrograms.SelectRandomNumber;

import java.util.Random;

public class SelectRandomNumber {

    private static int selectedNumber;
    private static int count;

    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < stream.length; i++) {
            selectRandomNumber(stream[i]);
            System.out.println("Random number selected so far: " + selectedNumber);
        }
    }

    private static void selectRandomNumber(int x) {
        count++;

        // For the first element, select it with probability 1
        if (count == 1) {
            selectedNumber = x;
            return;
        }

        // For elements beyond the first, select it with probability 1/count
        Random random = new Random();
        int probability = random.nextInt(count) + 1;

        if (probability == count) {
            selectedNumber = x;
        }
    }
}
