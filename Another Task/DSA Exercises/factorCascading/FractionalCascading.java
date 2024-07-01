package factorCascading;

import java.util.ArrayList;
import java.util.List;

public class FractionalCascading {
    private List<List<Integer>> sortedArrays;

    public FractionalCascading(List<List<Integer>> sortedArrays) {
        this.sortedArrays = sortedArrays;
    }

    public int binarySearch(int target) {
        int result = -1;

        for (int i = 0; i < sortedArrays.size(); i++) {
            int index = binarySearchInArray(sortedArrays.get(i), target);
            if (index >= 0) {
                result = index;
                if (i < sortedArrays.size() - 1) {
                    result = interpolate(i, result, target);
                }
            }
        }

        return result;
    }

    private int binarySearchInArray(List<Integer> array, int target) {
        int low = 0;
        int high = array.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int interpolate(int level, int index, int target) {
        List<Integer> nextArray = sortedArrays.get(level + 1);
        int nextIndex = binarySearchInArray(nextArray, target);

        if (nextIndex < 0) {
            nextIndex = -nextIndex - 1;
        }

        int size = nextArray.size();
        int startIndex = index * size / sortedArrays.get(level).size();
        int endIndex = (index + 1) * size / sortedArrays.get(level).size();

        if (nextIndex >= endIndex) {
            return index;
        }
        int interpolatedIndex = startIndex + (endIndex - startIndex) * (nextIndex - startIndex) / (endIndex - startIndex + 1);

        return interpolatedIndex;
    }

    public static void main(String[] args) {
        List<Integer> array1 = List.of(1, 3, 5, 7, 9);
        List<Integer> array2 = List.of(2, 4, 6, 8, 10);
        List<Integer> array3 = List.of(11, 13, 15, 17, 19);

        List<List<Integer>> sortedArrays = new ArrayList<>();
        sortedArrays.add(array1);
        sortedArrays.add(array2);
        sortedArrays.add(array3);

        FractionalCascading fractionalCascading = new FractionalCascading(sortedArrays);

        int target = 6;
        int result = fractionalCascading.binarySearch(target);

        if (result >= 0) {
            System.out.println("Found " + target + " at position " + result);
        } else {
            System.out.println(target + " not found in the sequence.");
        }
    }
}
