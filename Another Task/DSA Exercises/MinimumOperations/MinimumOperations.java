package dsaPrograms.MinimumOperations;

import java.util.*;

public class MinimumOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int minOperations = findMinOperations(N, arr);
        System.out.println("Minimum operations for pairing: " + minOperations);
    }

    private static int findMinOperations(int N, int[] arr) {
        int[] count = new int[2];
        int operations = 0;

        for (int i = 0; i < N; i++) {
            count[arr[i] % 2]++;
        }

        for (int i = 0; i < N; i += 2) {
            if (arr[i] % 2 != 0) {
                int target = arr[i] % 2 == 1 ? arr[i] - 1 : arr[i] + 1;

                if (count[target % 2] > 0) {
                    count[target % 2]--;
                } else {
                    operations++;
                }
            }
        }

        return operations;
    }
}
