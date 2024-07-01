package scapegoatTree;

import java.util.ArrayList;
import java.util.List;

public class ScapegoatTree<T extends Comparable<T>> {
    private static final double ALPHA = 0.666;

    private static class Node<T> {
        T key;
        Node<T> left, right, parent;

        Node(T key, Node<T> parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    private Node<T> root;
    private int size;

    public ScapegoatTree() {
        this.root = null;
        this.size = 0;
    }
    public void insert(T key) {
        root = insert(root, key, null);
        size++;
        if (size > ALPHA * getNodeCount(root)) {
            rebuild(root);
        }
    }
    private Node<T> insert(Node<T> node, T key, Node<T> parent) {
        if (node == null) {
            return new Node<>(key, parent);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, node);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, node);
        }

        return node;
    }
    private void rebuild(Node<T> scapegoat) {
        List<Node<T>> nodes = new ArrayList<>();
        flatten(scapegoat, nodes);

        if (scapegoat.parent == null) {
            root = buildBalanced(nodes, null);
        } else {
            Node<T> parent = scapegoat.parent;
            int cmp = (parent.right == scapegoat) ? 1 : -1;

            Node<T> balancedSubtree = buildBalanced(nodes, parent);
            if (cmp < 0) {
                parent.left = balancedSubtree;
            } else {
                parent.right = balancedSubtree;
            }
        }
    }
    private void flatten(Node<T> node, List<Node<T>> nodes) {
        if (node == null) {
            return;
        }

        flatten(node.left, nodes);
        nodes.add(node);
        flatten(node.right, nodes);
    }
    private Node<T> buildBalanced(List<Node<T>> nodes, Node<T> parent) {
        if (nodes.isEmpty()) {
            return null;
        }

        int mid = nodes.size() / 2;
        Node<T> root = nodes.get(mid);
        root.parent = parent;

        root.left = buildBalanced(nodes.subList(0, mid), root);
        root.right = buildBalanced(nodes.subList(mid + 1, nodes.size()), root);

        return root;
    }
    public boolean search(T key) {
        return search(root, key);
    }

    private boolean search(Node<T> node, T key) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return true;
        }
    }
    private int getNodeCount(Node<T> node) {
        return (node == null) ? 0 : 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }

    public static void main(String[] args) {
        ScapegoatTree<Integer> tree = new ScapegoatTree<>();

        // Insert keys
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);

        // Search for keys
        System.out.println("Search for 7: " + tree.search(7)); // true
        System.out.println("Search for 12: " + tree.search(12)); // false
    }
}
