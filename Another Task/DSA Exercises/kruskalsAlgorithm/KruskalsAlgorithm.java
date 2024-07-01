package kruskalsAlgorithm;

import java.util.*;

public class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
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
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }
    }

    static List<Edge> kruskalMST(List<Edge> edges, int numVertices) {
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        UnionFind unionFind = new UnionFind(numVertices);

        for (Edge edge : edges) {
            int rootSrc = unionFind.find(edge.src);
            int rootDest = unionFind.find(edge.dest);

            if (rootSrc != rootDest) {
                mst.add(edge);
                unionFind.union(rootSrc, rootDest);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int numVertices = 6;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 0, 4));
        edges.add(new Edge(2, 0, 4));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 5, 2));
        edges.add(new Edge(2, 4, 4));
        edges.add(new Edge(3, 2, 3));
        edges.add(new Edge(3, 4, 3));
        edges.add(new Edge(4, 2, 4));
        edges.add(new Edge(4, 3, 3));
        edges.add(new Edge(5, 2, 2));
        edges.add(new Edge(5, 4, 3));

        List<Edge> mst = kruskalMST(edges, numVertices);

        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " Weight: " + edge.weight);
        }
    }
}
