package treap;

import java.util.Random;

class TreapNode {
    int key;
    int priority;
    TreapNode left, right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt(Integer.MAX_VALUE);
        this.left = this.right = null;
    }
}

public class Treap {
    private TreapNode root;

    
    private TreapNode rightRotate(TreapNode y) {
        TreapNode x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    
    private TreapNode leftRotate(TreapNode x) {
        TreapNode y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreapNode insertRec(TreapNode root, int key) {
        if (root == null) {
            return new TreapNode(key);
        }

        
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        
        if (root.left != null && root.left.priority > root.priority) {
            root = rightRotate(root);
        } else if (root.right != null && root.right.priority > root.priority) {
            root = leftRotate(root);
        }

        return root;
    }

    
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private TreapNode deleteRec(TreapNode root, int key) {
        if (root == null) {
            return null;
        }

        
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            
            if (root.left.priority > root.right.priority) {
                root = rightRotate(root);
                root.right = deleteRec(root.right, key);
            } else {
                root = leftRotate(root);
                root.left = deleteRec(root.left, key);
            }
        }

        return root;
    }

    
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreapNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println("Key: " + root.key + ", Priority: " + root.priority);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Treap treap = new Treap();

        
        int[] keysToInsert = {5, 2, 8, 1, 4, 7, 9};
        for (int key : keysToInsert) {
            treap.insert(key);
        }

        System.out.println("treap.Treap after insertion:");
        treap.inOrderTraversal();
        System.out.println();

        
        treap.delete(4);

        System.out.println("treap.Treap after deletion:");
        treap.inOrderTraversal();
    }
}

