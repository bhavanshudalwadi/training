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

    void printPreorder(Node node) {
        if (node == null)
            return;
 
        System.out.print(node.key + " ");
 
        printPreorder(node.left);
 
        printPreorder(node.right);
    }

    void printInorder(Node node) {
        if (node == null)
            return;
 
        printInorder(node.left);
 
        System.out.print(node.key + " ");
 
        printInorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null)
            return;
 
        printPostorder(node.left);
 
        printPostorder(node.right);
 
        System.out.print(node.key + " ");
    }

    public static void main(String[] args) {
        Sixty tree = new Sixty();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Traversal of binary tree in preorder: ");
        tree.printPreorder(tree.root);
        System.out.println("\nTraversal of binary tree in inorder: ");
        tree.printInorder(tree.root);
        System.out.println("\nTraversal of binary tree in postorder: ");
        tree.printPostorder(tree.root);
    }
}

//         1
//     2       3
// 4       5
