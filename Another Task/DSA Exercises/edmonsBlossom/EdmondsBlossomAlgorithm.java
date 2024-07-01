package edmonsBlossom;

import java.util.*;

public class EdmondsBlossomAlgorithm {
    private int n;
    private boolean[][] graph;
    private int[] match;
    private int[] base;
    private int[] parent;

    public EdmondsBlossomAlgorithm(int n) {
        this.n = n;
        this.graph = new boolean[n][n];
        this.match = new int[n];
        Arrays.fill(match, -1);
        this.base = new int[n];
        this.parent = new int[n];
    }
    public void addEdge(int u, int v) {
        graph[u][v] = true;
        graph[v][u] = true;
    }
    private List<Integer> findAugmentingPath(int start) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] && !visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    if (match[v] == -1) {
                        // Found augmenting path
                        List<Integer> path = new ArrayList<>();
                        int current = v;
                        while (current != -1) {
                            path.add(current);
                            current = parent[current];
                        }
                        Collections.reverse(path);
                        return path;
                    }
                    queue.add(match[v]);
                }
            }
        }

        return Collections.emptyList();
    }
    private void contractBlossom(List<Integer> path, int blossomBase) {
        for (int u : path) {
            base[u] = blossomBase;
            for (int v = 0; v < n; v++) {
                graph[u][v] = graph[v][u] = false;
            }
        }
    }
    private void augmentMatching(List<Integer> path) {
        for (int i = 0; i < path.size() - 1; i += 2) {
            int u = path.get(i);
            int v = path.get(i + 1);
            match[u] = v;
            match[v] = u;
        }
    }
    public void findMaximumMatching() {
        for (int u = 0; u < n; u++) {
            if (match[u] == -1) {
                List<Integer> path = findAugmentingPath(u);
                if (!path.isEmpty()) {
                    int blossomBase = path.get(0);
                    contractBlossom(path, blossomBase);
                    augmentMatching(path);
                }
            }
        }
    }
    public List<int[]> getMaximumMatching() {
        List<int[]> matching = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            int v = match[u];
            if (v != -1 && u < v) {
                matching.add(new int[]{u, v});
            }
        }
        return matching;
    }

    public static void main(String[] args) {
        int n = 6;
        EdmondsBlossomAlgorithm blossomAlgorithm = new EdmondsBlossomAlgorithm(n);
        blossomAlgorithm.addEdge(0, 1);
        blossomAlgorithm.addEdge(1, 2);
        blossomAlgorithm.addEdge(2, 3);
        blossomAlgorithm.addEdge(3, 4);
        blossomAlgorithm.addEdge(4, 5);
        blossomAlgorithm.addEdge(5, 0);

        blossomAlgorithm.findMaximumMatching();

        List<int[]> maximumMatching = blossomAlgorithm.getMaximumMatching();
        System.out.println("Maximum Cardinality Matching:");
        for (int[] edge : maximumMatching) {
            System.out.println(edge[0] + " - " + edge[1]);
        }
    }
}

