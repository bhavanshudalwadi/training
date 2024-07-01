import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Searching {
    public static int linearSearch(ArrayList<Integer> list, int target) {
        int n = list.size();

        for (int i = 0; i < n; i++) {
            if (list.get(i) == target) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 50000; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(50000) + 1;
            list.add(randomNumber);
        }

        long start,end;

        start = new Date().getTime();
        linearSearch(list,802);
        end = new Date().getTime();
        System.out.println("linear search took "+ (end-start) + " miliseconds to find");
        System.out.println();


        start = new Date().getTime();
        binarySearch(list,802);
        end = new Date().getTime();
        System.out.println("binary search took "+ (end-start) + " miliseconds to find");
        System.out.println();

    }
}
