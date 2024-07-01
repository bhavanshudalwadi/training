package dsaPrograms.FindMinimum;

import java.util.Arrays;

class Node {
    double[] point;
    Node left, right;

    public Node(double[] point) {
        this.point = point;
        this.left = null;
        this.right = null;
    }
}

public class FindMinimum {
    private Node root;
    private int k;
    public FindMinimum(int k) {
        this.root = null;
        this.k = k;
    }

    public void insert(double[] point) {
        root = insert(root, point, 0);
    }

    private Node insert(Node node, double[] point, int depth) {
        if (node == null) {
            return new Node(point);
        }

        int axis = depth % k;

        if (point[axis] < node.point[axis]) {
            node.left = insert(node.left, point, depth + 1);
        } else {
            node.right = insert(node.right, point, depth + 1);
        }

        return node;
    }
    public double[] findMin() {
        if (root == null) {
            return null;
        }

        return findMin(root, 0);
    }

    private double[] findMin(Node node, int depth) {
        if (node == null) {
            return null;
        }

        int axis = depth % k;

        if (node.left == null) {
            return node.point;
        }

        double[] minLeft = findMin(node.left, depth + 1);
        double[] minRight = findMin(node.right, depth + 1);

        double[] result = node.point;

        for (int i = 0; i < k; i++) {
            if (minLeft[i] < result[i]) {
                result[i] = minLeft[i];
            }
            if (minRight[i] < result[i]) {
                result[i] = minRight[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindMinimum kdTree = new FindMinimum(2);

        double[] point1 = {2, 3};
        double[] point2 = {5, 4};
        double[] point3 = {9, 6};

        kdTree.insert(point1);
        kdTree.insert(point2);
        kdTree.insert(point3);

        double[] minPoint = kdTree.findMin();

        System.out.println("Minimum point in the k-d tree: " + Arrays.toString(minPoint));
    }
}
