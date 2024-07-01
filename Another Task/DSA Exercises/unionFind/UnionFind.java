package unionFind;

import java.util.HashMap;
import java.util.Map;

class UnionFind {
    private Map<Integer, Integer> parent;  // Stores the parent of each element
    private Map<Integer, Integer> rank;    // Stores the rank of each set
    private Map<Integer, Integer> version; // Stores the version of each element

    public int currentVersion; // Current version of the data structure

    public UnionFind() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
        this.version = new HashMap<>();
        this.currentVersion = 0;
    }

    // Initialize a new element in the data structure
    public void makeSet(int x) {
        parent.put(x, x);
        rank.put(x, 0);
        version.put(x, currentVersion);
    }

    // Find the representative of the set to which x belongs at a specific version
    public int find(int x, int queryVersion) {
        if (version.get(x) > queryVersion) {
            // x was modified after the query version, backtrack to the query version
            return find(parent.get(x), queryVersion);
        } else if (version.get(x) < queryVersion) {
            // x was modified before the query version, return x as it was at that version
            return x;
        } else {
            // x was modified at the query version
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x), queryVersion));
            }
            return parent.get(x);
        }
    }

    // Union the sets containing elements x and y
    public void union(int x, int y) {
        int rootX = find(x, currentVersion);
        int rootY = find(y, currentVersion);

        if (rootX != rootY) {
            if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }

            // Increment the version to create a new version of the data structure
            currentVersion++;
        }
    }
}
