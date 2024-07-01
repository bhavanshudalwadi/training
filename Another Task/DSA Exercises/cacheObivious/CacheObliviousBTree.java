package cacheObivious;

import java.util.ArrayList;
import java.util.List;

public class CacheObliviousBTree<T extends Comparable<T>> {
    private static final int MIN_KEYS = 2;
    private static final int MAX_KEYS = 2 * MIN_KEYS;
    private Node root;

    private static class Node<T> {
        List<T> keys;
        List<Node> children;
        Node() {
            keys = new ArrayList<>();
            children = new ArrayList<>();
        }
    }

    public CacheObliviousBTree() {
        root = new Node();
    }

    public void insert(T key) {
        Node newRoot = insert(root, key);
        if (newRoot != null) {
            root = newRoot;
        }
    }

    private Node insert(Node node, T key) {
        if (node.children.isEmpty()) {
            insertIntoLeaf(node, key);
        } else {
            int childIndex = findChildIndex(node, key);
            Node child = (Node) node.children.get(childIndex);
            Node newChild = insert(child, key);

            if (newChild != null) {
                insertIntoNode(node, childIndex, (T) newChild.keys.get(0), newChild);
                if (node.keys.size() > MAX_KEYS) {
                    return splitNode(node);
                }
            }
        }

        return null;
    }

    private void insertIntoLeaf(Node node, T key) {
        int index = findKeyIndex(node, key);
        node.keys.add(index, key);
    }

    private void insertIntoNode(Node node, int index, T key, Node child) {
        node.keys.add(index, key);
        node.children.add(index + 1, child);
    }

    private Node splitNode(Node node) {
        int splitIndex = node.keys.size() / 2;
        Node newNode = new Node();

        newNode.keys.addAll(node.keys.subList(splitIndex + 1, node.keys.size()));
        newNode.children.addAll(node.children.subList(splitIndex + 1, node.children.size()));
        node.keys.subList(splitIndex, node.keys.size()).clear();
        node.children.subList(splitIndex + 1, node.children.size()).clear();

        return newNode;
    }

    private int findKeyIndex(Node node, T key) {
        int index = 0;
        while (index < node.keys.size() && key.compareTo((T) node.keys.get(index)) > 0) {
            index++;
        }
        return index;
    }

    private int findChildIndex(Node node, T key) {
        int index = 0;
        while (index < node.keys.size() && key.compareTo((T) node.keys.get(index)) > 0) {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        CacheObliviousBTree<Integer> cacheObliviousBTree = new CacheObliviousBTree<>();

        cacheObliviousBTree.insert(10);
        cacheObliviousBTree.insert(5);
        cacheObliviousBTree.insert(15);
        cacheObliviousBTree.insert(2);
        cacheObliviousBTree.insert(7);

    }
}
