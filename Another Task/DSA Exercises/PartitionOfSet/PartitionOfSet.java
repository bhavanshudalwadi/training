package dsaPrograms.PartitionOfSet;

import java.util.Arrays;

public class PartitionOfSet {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 5, 6};
        int k1 = 3;
        System.out.println("Can be partitioned into " + k1 + " subsets with equal sum: " + canPartitionKSubsets(arr1, k1));

        int[] arr2 = {2, 1, 5, 5, 6};
        int k2 = 3;
        System.out.println("Can be partitioned into " + k2 + " subsets with equal sum: " + canPartitionKSubsets(arr2, k2));
    }

    private static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0) {
            return false;
        }

        int targetSum = sum / k;
        boolean[] visited = new boolean[nums.length];

        return canPartition(nums, k, targetSum, 0, 0, visited);
    }

    private static boolean canPartition(int[] nums, int k, int targetSum, int currentSum, int start, boolean[] visited) {
        if (k == 0) {
            return true;
        }

        if (currentSum == targetSum) {
            return canPartition(nums, k - 1, targetSum, 0, 0, visited);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (canPartition(nums, k, targetSum, currentSum + nums[i], i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
