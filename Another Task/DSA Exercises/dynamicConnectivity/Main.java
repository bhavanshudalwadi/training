package dynamicConnectivity;

// Java implementation of
// incremental connectivity

public class Main {
    static int root(int arr[], int i)
    {
        while (arr[i] != i)
        {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
    static void weighted_union(int arr[], int rank[],
                               int a, int b)
    {
        int root_a = root (arr, a);
        int root_b = root (arr, b);
        if (rank[root_a] < rank[root_b])
        {
            arr[root_a] = arr[root_b];
            rank[root_b] += rank[root_a];
        }
        else
        {
            arr[root_b] = arr[root_a];
            rank[root_a] += rank[root_b];
        }
    }
    static boolean areSame(int arr[],
                           int a, int b)
    {
        return (root(arr, a) == root(arr, b));
    }
    static void query(int type, int x, int y, int arr[], int rank[]) {
        if (type == 1)
        {
            if (areSame(arr, x, y) == true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        else if (type == 2)
        {
            if (areSame(arr, x, y) == false)
                weighted_union(arr, rank, x, y);
        }
    }
    public static void main(String[] args)
    {
        int n = 7;
        int []arr = new int[n];
        int []rank = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = i;
            rank[i] = 1;
        }
        int q = 11;
        query(1, 0, 1, arr, rank);
        query(2, 0, 1, arr, rank);
        query(2, 1, 2, arr, rank);
        query(1, 0, 2, arr, rank);
        query(2, 0, 2, arr, rank);
        query(2, 2, 3, arr, rank);
        query(2, 3, 4, arr, rank);
        query(1, 0, 5, arr, rank);
        query(2, 4, 5, arr, rank);
        query(2, 5, 6, arr, rank);
        query(1, 2, 6, arr, rank);
    }
}


