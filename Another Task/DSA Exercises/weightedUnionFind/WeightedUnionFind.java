package weightedUnionFind;

import java.util.Arrays;

public class WeightedUnionFind {

    private int[] parent;  
    private int[] size;    

    public WeightedUnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);

        
        for (int i = 0; i < n; i++) {
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
            
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    
    public int getSize(int x) {
        return size[find(x)];
    }

    public static void main(String[] args) {
        WeightedUnionFind uf = new WeightedUnionFind(5);

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(1, 4);

        System.out.println("Is 0 connected to 4? " + uf.isConnected(0, 4)); 
        System.out.println("Size of set containing 0: " + uf.getSize(0));   
    }
}
