// Binary Tree Traversal

class Node {
    int key;
    Node left, right;
 
    Node(int item) {
        key = item;
        left = right = null;
    }
}

class Sixty {
    Node root;
 
    Sixty() { this.root = null; }

    int printInorder(Node node, int cnt) {
        if (node == null)
            return;
 
        printInorder(node.left);
 
        System.out.print(node.key + " ");
 
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Sixty tree = new Sixty();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("\nTraversal of binary tree: ");
        tree.printInorder(tree.root);
    }
}

//         1
//     2       3
// 4       5
