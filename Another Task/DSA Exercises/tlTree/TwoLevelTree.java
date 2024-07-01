package tlTree;

public class TwoLevelTree<V> {
    private static class Node<V> {
        boolean isLeaf;
        Node<V> left, right;
        TrieNode<V> trieNode;

        Node() {
            this.isLeaf = false;
            this.left = null;
            this.right = null;
            this.trieNode = null;
        }
    }

    private static class TrieNode<V> {
        V value;
        TrieNode<V>[] children;

        TrieNode() {
            this.value = null;
            this.children = new TrieNode[2]; // Binary trie for remaining bits
        }
    }

    private Node<V> root;

    public TwoLevelTree() {
        this.root = new Node<>();
    }

    public void insert(int key, V value) {
        root = insert(root, key, value, 31); // Assuming 32-bit integers
    }

    private Node<V> insert(Node<V> node, int key, V value, int bitIndex) {
        if (node == null) {
            node = new Node<>();
        }

        if (bitIndex < 0) {
            node.isLeaf = true;
            if (node.trieNode == null) {
                node.trieNode = new TrieNode<>();
            }
            node.trieNode.value = value;
        } else {
            int bit = (key >> bitIndex) & 1;
            if (bit == 0) {
                node.left = insert(node.left, key, value, bitIndex - 1);
            } else {
                node.right = insert(node.right, key, value, bitIndex - 1);
            }
        }

        return node;
    }

    public V search(int key) {
        Node<V> node = search(root, key, 31); // Assuming 32-bit integers
        return (node != null && node.isLeaf && node.trieNode != null) ? node.trieNode.value : null;
    }

    private Node<V> search(Node<V> node, int key, int bitIndex) {
        if (node == null) {
            return null;
        }

        if (bitIndex < 0) {
            return (node.isLeaf && node.trieNode != null) ? node : null;
        }

        int bit = (key >> bitIndex) & 1;
        if (bit == 0) {
            return search(node.left, key, bitIndex - 1);
        } else {
            return search(node.right, key, bitIndex - 1);
        }
    }

    public static void main(String[] args) {
        TwoLevelTree<String> twoLevelTree = new TwoLevelTree<>();

        twoLevelTree.insert(5, "Value1");
        twoLevelTree.insert(10, "Value2");
        twoLevelTree.insert(7, "Value3");

        System.out.println("Search for key 5: " + twoLevelTree.search(5)); // Value1
        System.out.println("Search for key 8: " + twoLevelTree.search(8)); // null
        System.out.println("Search for key 10: " + twoLevelTree.search(10)); // Value2
    }
}
