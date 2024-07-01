package unionFind;

import java.util.HashMap;
import java.util.Map;

public class PersistentUnionFind {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind();

        // Make sets
        for (int i = 1; i <= 5; i++) {
            uf.makeSet(i);
        }

        // Union sets at version 0
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(4, 5);

        // Query the data structure at version 0
        System.out.println("At version 0:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Parent of " + i + ": " + uf.find(i, 0));
        }

        // Union sets at version 1
        uf.union(2, 3);

        // Query the data structure at version 1
        System.out.println("\nAt version 1:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Parent of " + i + ": " + uf.find(i, 1));
        }

        // Query the data structure at the latest version
        System.out.println("\nAt the latest version:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Parent of " + i + ": " + uf.find(i, uf.currentVersion));
        }
    }
}

