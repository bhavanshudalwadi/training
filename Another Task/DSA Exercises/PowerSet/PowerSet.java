package dsaPrograms.PowerSet;

import java.util.Arrays;

public class PowerSet {

    public static void main(String[] args) {
        String input = "abc";
        generatePowerSet(input);
    }

    private static void generatePowerSet(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray); // Sort the characters to ensure lexicographic order
        str = new String(charArray);

        generatePowerSetHelper(str, "", 0);
    }

    private static void generatePowerSetHelper(String str, String currentSubset, int index) {
        int n = str.length();

        System.out.println(currentSubset);

        for (int i = index; i < n; i++) {
            generatePowerSetHelper(str, currentSubset + str.charAt(i), i + 1);
        }
    }
}
