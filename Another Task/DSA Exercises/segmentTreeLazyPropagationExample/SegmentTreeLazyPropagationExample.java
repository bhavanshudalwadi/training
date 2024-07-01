package segmentTreeLazyPropagationExample;

class SegmentTree {
    private int[] tree;
    private int[] lazy;
    private int size;

    public SegmentTree(int[] arr) {
        size = arr.length;
        tree = new int[4 * size];
        lazy = new int[4 * size];
        buildTree(arr, 1, 0, size - 1);
    }

    private void buildTree(int[] arr, int index, int start, int end) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildTree(arr, 2 * index, start, mid);
        buildTree(arr, 2 * index + 1, mid + 1, end);
        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    public void updateRange(int start, int end, int delta) {
        updateRangeUtil(1, 0, size - 1, start, end, delta);
    }

    private void updateRangeUtil(int index, int start, int end, int queryStart, int queryEnd, int delta) {
        if (lazy[index] != 0) {
            tree[index] += (end - start + 1) * lazy[index];

            if (start != end) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (start > end || start > queryEnd || end < queryStart) {
            return;
        }

        if (start >= queryStart && end <= queryEnd) {
            tree[index] += (end - start + 1) * delta;

            if (start != end) {
                lazy[2 * index] += delta;
                lazy[2 * index + 1] += delta;
            }

            return;
        }

        int mid = (start + end) / 2;
        updateRangeUtil(2 * index, start, mid, queryStart, queryEnd, delta);
        updateRangeUtil(2 * index + 1, mid + 1, end, queryStart, queryEnd, delta);

        tree[index] = tree[2 * index] + tree[2 * index + 1];
    }

    public int queryRange(int start, int end) {
        return queryRangeUtil(1, 0, size - 1, start, end);
    }

    private int queryRangeUtil(int index, int start, int end, int queryStart, int queryEnd) {
        if (lazy[index] != 0) {
            tree[index] += (end - start + 1) * lazy[index];

            if (start != end) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (start > end || start > queryEnd || end < queryStart) {
            return 0;
        }

        if (start >= queryStart && end <= queryEnd) {
            return tree[index];
        }

        int mid = (start + end) / 2;
        int left = queryRangeUtil(2 * index, start, mid, queryStart, queryEnd);
        int right = queryRangeUtil(2 * index + 1, mid + 1, end, queryStart, queryEnd);

        return left + right;
    }
}

public class SegmentTreeLazyPropagationExample {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree segmentTree = new SegmentTree(arr);

        
        segmentTree.updateRange(1, 3, 2);

        
        int sum = segmentTree.queryRange(2, 5);

        System.out.println("Sum in the range [2, 5]: " + sum); 
    }
}
