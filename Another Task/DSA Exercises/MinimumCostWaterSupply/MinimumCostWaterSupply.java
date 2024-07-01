package dsaPrograms.MinimumCostWaterSupply;

import java.util.*;

public class MinimumCostWaterSupply {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] wells = new int[N];
        for (int i = 0; i < N; i++) {
            wells[i] = scanner.nextInt();
        }

        int P = scanner.nextInt();
        int[][] pipes = new int[P][3];
        for (int i = 0; i < P; i++) {
            pipes[i][0] = scanner.nextInt();
            pipes[i][1] = scanner.nextInt();
            pipes[i][2] = scanner.nextInt();
        }

        int minCost = minCostToSupplyWater(N, wells, pipes);
        System.out.println("Minimum cost to provide water: " + minCost);
    }

    private static int minCostToSupplyWater(int N, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();

        for (int[] pipe : pipes) {
            edges.add(new int[]{pipe[0], pipe[1], pipe[2]});
        }

        for (int i = 0; i < N; i++) {
            edges.add(new int[]{0, i + 1, wells[i]});
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        UnionFind unionFind = new UnionFind(N + 1);

        int minCost = 0;

        // Kruskal's algorithm
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (unionFind.union(u, v)) {
                minCost += cost;
            }
        }

        return minCost;
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            }

            return false;
        }
    }
}
