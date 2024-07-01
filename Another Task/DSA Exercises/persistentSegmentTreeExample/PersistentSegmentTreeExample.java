package persistentSegmentTreeExample;

class PersistentSegmentTree {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node left, Node right) {
            this.value = left.value + right.value;
            this.left = left;
            this.right = right;
        }
    }

    private Node[] versions;
    private int versionCount;

    public PersistentSegmentTree(int[] arr) {
        versions = new Node[arr.length * 4];
        versionCount = 0;
        buildTree(arr, 0, arr.length - 1, 0);
    }

    private Node buildTree(int[] arr, int start, int end, int version) {
        if (start == end) {
            return new Node(arr[start]);
        }

        int mid = (start + end) / 2;
        Node leftChild = buildTree(arr, start, mid, version);
        Node rightChild = buildTree(arr, mid + 1, end, version);
        return new Node(leftChild, rightChild);
    }

    public int query(int version, int start, int end, int queryStart, int queryEnd) {
        if (version < 0 || version > versionCount) {
            throw new IllegalArgumentException("Invalid version");
        }
        return queryUtil(versions[version], start, end, queryStart, queryEnd);
    }

    private int queryUtil(Node node, int start, int end, int queryStart, int queryEnd) {
        if (node == null || queryStart > end || queryEnd < start) {
            return 0;
        }

        if (queryStart <= start && queryEnd >= end) {
            return node.value;
        }

        int mid = (start + end) / 2;
        int leftSum = queryUtil(node.left, start, mid, queryStart, queryEnd);
        int rightSum = queryUtil(node.right, mid + 1, end, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    public int update(int version, int start, int end, int index, int newValue) {
        if (version < 0 || version > versionCount) {
            throw new IllegalArgumentException("Invalid version");
        }
        versions[versionCount + 1] = updateUtil(versions[version], start, end, index, newValue);
        return ++versionCount;
    }

    private Node updateUtil(Node node, int start, int end, int index, int newValue) {
        if (node == null) {
            return new Node(newValue);
        }

        if (start == end) {
            return new Node(newValue);
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            return new Node(updateUtil(node.left, start, mid, index, newValue), node.right);
        } else {
            return new Node(node.left, updateUtil(node.right, mid + 1, end, index, newValue));
        }
    }
}

public class PersistentSegmentTreeExample {
    public static void main(String[] args) {
        int[] initialArray = {1, 2, 3, 4, 5};
        PersistentSegmentTree persistentSegmentTree = new PersistentSegmentTree(initialArray);

        
        int sum1 = persistentSegmentTree.query(0, 0, initialArray.length - 1, 1, 3);
        System.out.println("Query result on version 0: " + sum1); 

        
        int newVersion = persistentSegmentTree.update(0, 0, initialArray.length - 1, 2, 10);

        
        int sum2 = persistentSegmentTree.query(newVersion, 0, initialArray.length - 1, 1, 3);
        System.out.println("Query result on the new version: " + sum2); 
    }
}
