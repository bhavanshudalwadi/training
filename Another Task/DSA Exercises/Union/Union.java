package dsaPrograms.Union;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the root of the set to which element x belongs (with path compression)
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // dsaPrograms.Union.Union two sets by rank
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

    // Check if two elements belong to the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

public class Union {
    public static void main(String[] args) {
        int size = 5;
        UnionFind uf = new UnionFind(size);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println("Is 0 connected to 2? " + uf.isConnected(0, 2)); // Should be false
        System.out.println("Is 3 connected to 4? " + uf.isConnected(3, 4)); // Should be true

        uf.union(2, 3);

        System.out.println("Is 0 connected to 2? " + uf.isConnected(0, 2)); // Should be true
    }
}
