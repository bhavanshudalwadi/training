package randomNumberFromStream;

import java.util.Random;

public class RandomNumberFromStream {
    private int result;
    private int count;

    public int selectRandom(int streamValue) {
        count++;
        if (count == 1) {
            result = streamValue;
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(count);
            if (randomIndex == 0) {
                result = streamValue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RandomNumberFromStream randomNumberSelector = new RandomNumberFromStream();

        
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        
        for (int i : stream) {
            int randomSelected = randomNumberSelector.selectRandom(i);
            System.out.println("Random number from stream: " + randomSelected);
        }
    }
}
