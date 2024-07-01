package dsaPrograms.InsertSearchInDimensionalTree;

import java.util.Arrays;

class Node1 {
    double[] point;
    Node1 left, right;

    public Node1(double[] point) {
        this.point = point;
        this.left = null;
        this.right = null;
    }
}

public class InsertSearchInDimensionalTree {
    private Node1 root;
    private int k;

    public InsertSearchInDimensionalTree(int k) {
        this.root = null;
        this.k = k;
    }

    public void insert(double[] point) {
        root = insert(root, point, 0);
    }

    private Node1 insert(Node1 node, double[] point, int depth) {
        if (node == null) {
            return new Node1(point);
        }

        int axis = depth % k;

        if (point[axis] < node.point[axis]) {
            node.left = insert(node.left, point, depth + 1);
        } else {
            node.right = insert(node.right, point, depth + 1);
        }

        return node;
    }

    public boolean search(double[] point) {
        return search(root, point, 0);
    }

    private boolean search(Node1 node, double[] point, int depth) {
        if (node == null) {
            return false;
        }

        if (isEqual(node.point, point)) {
            return true;
        }

        int axis = depth % k;

        if (point[axis] < node.point[axis]) {
            return search(node.left, point, depth + 1);
        } else {
            return search(node.right, point, depth + 1);
        }
    }

    private boolean isEqual(double[] point1, double[] point2) {
        for (int i = 0; i < k; i++) {
            if (point1[i] != point2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InsertSearchInDimensionalTree kdTree = new InsertSearchInDimensionalTree(2);

        double[] point1 = {2, 3};
        double[] point2 = {5, 4};
        double[] point3 = {9, 6};

        kdTree.insert(point1);
        kdTree.insert(point2);
        kdTree.insert(point3);

        double[] searchPoint = {5, 4};
        boolean found = kdTree.search(searchPoint);

        System.out.println("Is point " + Arrays.toString(searchPoint) + " in the k-d tree? " + found);
    }
}
