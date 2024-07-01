package suffixArray;

import java.util.Arrays;

public class SuffixArray {

    
    static class Suffix implements Comparable<Suffix> {
        int index;
        String suffix;

        Suffix(int index, String suffix) {
            this.index = index;
            this.suffix = suffix;
        }

        @Override
        public int compareTo(Suffix other) {
            return this.suffix.compareTo(other.suffix);
        }
    }

    
    public static int[] buildSuffixArray(String text) {
        int n = text.length();
        Suffix[] suffixes = new Suffix[n];

        
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, text.substring(i));
        }

        
        Arrays.sort(suffixes);

        
        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = suffixes[i].index;
        }

        return suffixArray;
    }

    public static void main(String[] args) {
        String inputString = "banana";
        int[] suffixArray = buildSuffixArray(inputString);

        
        System.out.println("Suffix Array for \"" + inputString + "\":");
        for (int i = 0; i < suffixArray.length; i++) {
            System.out.println(suffixArray[i] + ": " + inputString.substring(suffixArray[i]));
        }
    }
}
