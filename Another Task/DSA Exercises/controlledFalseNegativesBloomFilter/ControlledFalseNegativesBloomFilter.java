package controlledFalseNegativesBloomFilter;

import java.util.BitSet;
import java.util.Random;

public class ControlledFalseNegativesBloomFilter {
    private BitSet bitSet;
    private int size;
    private int numHashFunctions;
    private double falseNegativeRate; 
    private int expectedNumberOfElements;

    public ControlledFalseNegativesBloomFilter(int expectedNumberOfElements, double falseNegativeRate) {
        this.expectedNumberOfElements = expectedNumberOfElements;
        this.falseNegativeRate = falseNegativeRate;
        this.size = calculateOptimalSize(expectedNumberOfElements, falseNegativeRate);
        this.numHashFunctions = calculateOptimalHashFunctions(expectedNumberOfElements, size);
        this.bitSet = new BitSet(size);
    }

    
    public void add(String element) {
        int[] hashValues = hash(element);
        for (int hashValue : hashValues) {
            bitSet.set(hashValue, true);
        }
    }

    
    public boolean contains(String element) {
        int[] hashValues = hash(element);
        for (int hashValue : hashValues) {
            if (!bitSet.get(hashValue)) {
                return false;
            }
        }
        return true;
    }

    
    private int[] hash(String element) {
        int[] hashValues = new int[numHashFunctions];
        Random random = new Random(element.hashCode());
        for (int i = 0; i < numHashFunctions; i++) {
            hashValues[i] = Math.abs(random.nextInt()) % size;
        }
        return hashValues;
    }

    
    private int calculateOptimalSize(int expectedNumberOfElements, double falseNegativeRate) {
        return (int) Math.ceil(-expectedNumberOfElements * Math.log(falseNegativeRate) / Math.pow(Math.log(2), 2));
    }

    
    private int calculateOptimalHashFunctions(int expectedNumberOfElements, int size) {
        return (int) Math.ceil((size / expectedNumberOfElements) * Math.log(2));
    }

    public static void main(String[] args) {
        ControlledFalseNegativesBloomFilter bloomFilter = new ControlledFalseNegativesBloomFilter(1000, 0.01);

        
        bloomFilter.add("example1");
        bloomFilter.add("example2");
        bloomFilter.add("example3");

        
        System.out.println(bloomFilter.contains("example1")); 
        System.out.println(bloomFilter.contains("example4")); 
    }
}
