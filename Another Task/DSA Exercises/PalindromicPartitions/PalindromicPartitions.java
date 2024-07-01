package dsaPrograms.PalindromicPartitions;

public class PalindromicPartitions {

    public static void main(String[] args) {
        String input1 = "nitin";
        System.out.println("Palindromic partitions for \"" + input1 + "\":");
        printAllPalindromicPartitions(input1);

        String input2 = "geeks";
        System.out.println("\nPalindromic partitions for \"" + input2 + "\":");
        printAllPalindromicPartitions(input2);
    }

    private static void printAllPalindromicPartitions(String input) {
        int n = input.length();

        for (int i = 0; i < (1 << (n - 1)); i++) {
            StringBuilder currentPartition = new StringBuilder();
            int lastCut = 0;

            for (int j = 0; j < n - 1; j++) {
                currentPartition.append(input.charAt(j));
                if ((i & (1 << j)) > 0) {
                    currentPartition.append("|");
                    lastCut = j + 1;
                }
            }

            currentPartition.append(input.substring(lastCut));
            if (isPalindromic(currentPartition.toString())) {
                System.out.println(currentPartition);
            }
        }
    }

    private static boolean isPalindromic(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
