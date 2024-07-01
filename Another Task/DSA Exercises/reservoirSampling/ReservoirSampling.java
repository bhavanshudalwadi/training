package reservoirSampling;

import java.util.Arrays;
import java.util.Random;

public class ReservoirSampling {
    private final int k; 
    private int[] reservoir;
    private int count;

    public ReservoirSampling(int k) {
        this.k = k;
        this.reservoir = new int[k];
        this.count = 0;
    }

    public void processElement(int element) {
        count++;

        
        if (count <= k) {
            reservoir[count - 1] = element;
        } else {
            
            Random rand = new Random();
            int randomIndex = rand.nextInt(count);
            if (randomIndex < k) {
                reservoir[randomIndex] = element;
            }
        }
    }

    public int[] getReservoir() {
        return Arrays.copyOf(reservoir, k);
    }

    public static void main(String[] args) {
        int totalElements = 1000;
        int reservoirSize = 5;

        ReservoirSampling reservoirSampling = new ReservoirSampling(reservoirSize);

        
        for (int i = 1; i <= totalElements; i++) {
            reservoirSampling.processElement(i);
        }

        
        int[] finalReservoir = reservoirSampling.getReservoir();

        
        System.out.println("Sampled elements: " + Arrays.toString(finalReservoir));
    }
}
