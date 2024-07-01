package cartesianTree;

class Node {
    int key;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

public class CartesianTree {
    static Node root;

    
    static Node buildCartesianTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        root = buildCartesianTreeHelper(arr, 0, arr.length - 1);
        return root;
    }

    
    private static Node buildCartesianTreeHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        
        int maxIndex = findMaxIndex(arr, start, end);

        
        Node root = new Node(arr[maxIndex]);

        
        root.left = buildCartesianTreeHelper(arr, start, maxIndex - 1);
        root.right = buildCartesianTreeHelper(arr, maxIndex + 1, end);

        return root;
    }

    
    private static int findMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    
    static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};

        
        buildCartesianTree(arr);

        
        System.out.println("In-order traversal of Cartesian Tree:");
        inOrderTraversal(root);
    }
}
