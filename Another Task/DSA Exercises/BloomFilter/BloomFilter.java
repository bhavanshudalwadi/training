package BloomFilter;

import java.util.BitSet;


public class BloomFilter {
    private BitSet bitSet;
    private int size;
    private int[] hashFunctions;

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashFunctions = new int[numHashFunctions];
        generateHashFunctions();
    }

    private void generateHashFunctions() {
        for (int i = 0; i < hashFunctions.length; i++) {
            hashFunctions[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
    }

    public void add(String element) {
        for (int hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction % size);
            bitSet.set(index, true);
        }
    }

    public boolean contains(String element) {
        for (int hashFunction : hashFunctions) {
            int index = Math.abs(hashFunction % size);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(100, 3);

        
        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("orange");

        
        System.out.println("Contains 'apple': " + bloomFilter.contains("apple")); 
        System.out.println("Contains 'grape': " + bloomFilter.contains("grape")); 
    }
}

