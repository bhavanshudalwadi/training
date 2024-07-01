import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class SixtySix {

    private int V, E; 
    private Edge[] edges;

    public KruskalsAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge(0, 0, 0);
        }
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;

        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1) {
            Edge nextEdge = edges[e++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e - 1] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges of the Minimum Spanning Tree (MST):");
        for (int i = 0; i < e - 1; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + " Weight: " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.kruskalMST();
    }
}
