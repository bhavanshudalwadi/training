package P71to100;

import java.util.*;

public class p74 {
    private int V; // Number of vertices
    private List<Integer>[] graph; // Adjacency list representation
    private List<Integer>[] dominators; // List of dominators for each vertex
    private List<Integer>[] reverseGraph; // Reverse graph for immediate dominators

    // Constructor
    public p74(int vertices) {
        V = vertices;
        graph = new ArrayList[V];
        dominators = new ArrayList[V];
        reverseGraph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
            dominators[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int u, int v) {
        graph[u].add(v);
        reverseGraph[v].add(u);
    }

    // Function to find dominators using Tarjan's Algorithm
    public void findDominators() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        dfs(0, visited, stack);

        for (int i = 0; i < V; i++) {
            dominators[i].add(i);
        }

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (v != 0) {
                for (int u : reverseGraph[v]) {
                    List<Integer> intersect = new ArrayList<>(dominators[u]);
                    intersect.retainAll(dominators[v]);
                    dominators[v].clear();
                    dominators[v].add(v);
                    dominators[v].addAll(intersect);
                }
            }
        }
    }

    // Helper function for DFS traversal
    private void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int u : graph[v]) {
            if (!visited[u]) {
                dfs(u, visited, stack);
            }
        }

        stack.push(v);
    }

    // Function to print dominators for each vertex
    public void printDominators() {
        for (int i = 0; i < V; i++) {
            System.out.print("Dominators for vertex " + i + ": ");
            for (int dom : dominators[i]) {
                System.out.print(dom + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TarjansAlgorithmDominators graph = new TarjansAlgorithmDominators(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        graph.findDominators();
        graph.printDominators();
    }
}
