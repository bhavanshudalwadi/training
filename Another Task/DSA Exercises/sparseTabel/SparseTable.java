package sparseTabel;

public class SparseTable {
    private int[][] table;
    private int[] logTable;
    private int[] array;

    public SparseTable(int[] array) {
        this.array = array;
        int n = array.length;
        int logN = (int) (Math.log(n) / Math.log(2)) + 1;

        table = new int[n][logN];
        logTable = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            table[i][0] = i;
        }

        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                int x = table[i][j - 1];
                int y = table[i + (1 << (j - 1))][j - 1];
                table[i][j] = (array[x] <= array[y]) ? x : y;
            }
        }
    }

    public int query(int left, int right) {
        int k = logTable[right - left + 1];
        int x = table[left][k];
        int y = table[right - (1 << k) + 1][k];
        return (array[x] <= array[y]) ? x : y;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 7, 9, 4};
        SparseTable sparseTable = new SparseTable(array);

        System.out.println("Range Minimum Queries:");
        System.out.println("Minimum in range [1, 4]: " + array[sparseTable.query(1, 4)]);
        System.out.println("Minimum in range [2, 5]: " + array[sparseTable.query(2, 5)]);
        System.out.println("Minimum in range [0, 6]: " + array[sparseTable.query(0, 6)]);
    }
}

