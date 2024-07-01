package dsaPrograms.DisjointSet;

import java.util.*;

public class DisjointSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNodes = scanner.nextInt();
        int[] weights = new int[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            weights[i] = scanner.nextInt();
        }

        List<Edge> edges = new ArrayList<>();
        int numberOfEdges = numberOfNodes - 1;

        for (int i = 0; i < numberOfEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new Edge(u, v));
        }

        int result = getMaximumWeightDifference(numberOfNodes, weights, edges);
        System.out.println("Maximum weight difference: " + result);
    }

    private static int getMaximumWeightDifference(int numberOfNodes, int[] weights, List<Edge> edges) {

        UnionFind unionFind = new UnionFind(numberOfNodes);

        Map<Integer, Integer> nodeToWeight = new HashMap<>();
        for (int i = 0; i < numberOfNodes; i++) {
            nodeToWeight.put(i + 1, weights[i]);
        }

        edges.sort((e1, e2) -> Integer.compare(nodeToWeight.get(e2.v), nodeToWeight.get(e1.v)));

        int result = Integer.MIN_VALUE;

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            int rootU = unionFind.find(u);
            int rootV = unionFind.find(v);

            if (rootU != rootV) {
                int weightU = nodeToWeight.get(rootU);
                int weightV = nodeToWeight.get(rootV);

                int weightDifference = Math.abs(weightU - weightV);
                result = Math.max(result, weightDifference);

                unionFind.union(u, v);
                int newRoot = unionFind.find(u);
                nodeToWeight.put(newRoot, Math.max(weightU, weightV));
            }
        }

        return result;
    }

    static class Edge {
        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
