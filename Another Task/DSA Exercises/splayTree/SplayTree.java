package splayTree;

class Node {
    int key;
    Node left, right, parent;

    public Node(int key) {
        this.key = key;
        this.left = this.right = this.parent = null;
    }
}

public class SplayTree {
    private Node root;

    public SplayTree() {
        this.root = null;
    }

    
    private void zig(Node x) {
        Node parent = x.parent;
        if (parent.left == x) {
            parent.left = x.right;
            if (x.right != null) {
                x.right.parent = parent;
            }
            x.right = parent;
        } else {
            parent.right = x.left;
            if (x.left != null) {
                x.left.parent = parent;
            }
            x.left = parent;
        }

        x.parent = parent.parent;
        parent.parent = x;
        if (x.parent != null) {
            if (x.parent.left == parent) {
                x.parent.left = x;
            } else {
                x.parent.right = x;
            }
        } else {
            root = x;
        }
    }

    
    private void zigZig(Node x) {
        Node parent = x.parent;
        Node grandParent = parent.parent;

        if (parent.left == x && grandParent.left == parent) {
            parent.left = x.right;
            if (x.right != null) {
                x.right.parent = parent;
            }
            x.right = parent;

            grandParent.left = parent.right;
            if (parent.right != null) {
                parent.right.parent = grandParent;
            }
            parent.right = grandParent;
        } else {
            parent.right = x.left;
            if (x.left != null) {
                x.left.parent = parent;
            }
            x.left = parent;

            grandParent.right = parent.left;
            if (parent.left != null) {
                parent.left.parent = grandParent;
            }
            parent.left = grandParent;
        }

        x.parent = grandParent.parent;
        grandParent.parent = parent.parent = x;

        if (x.parent != null) {
            if (x.parent.left == grandParent) {
                x.parent.left = x;
            } else {
                x.parent.right = x;
            }
        } else {
            root = x;
        }
    }

    
    private void splay(Node x) {
        while (x.parent != null) {
            Node parent = x.parent;
            Node grandParent = parent.parent;

            if (grandParent == null) {
                zig(x);
            } else if ((parent.left == x && grandParent.left == parent) || (parent.right == x && grandParent.right == parent)) {
                zigZig(x);
            } else {
                zig(x);
                zig(x);
            }
        }
    }

    
    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return;
            }
        }

        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        newNode.parent = parent;
        splay(newNode);
    }

    
    public boolean search(int key) {
        Node foundNode = searchNode(key);
        if (foundNode != null) {
            splay(foundNode);
            return true;
        }
        return false;
    }

    
    private Node searchNode(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    
    public void delete(int key) {
        Node nodeToDelete = searchNode(key);

        if (nodeToDelete != null) {
            splay(nodeToDelete);

            if (nodeToDelete.left == null) {
                root = nodeToDelete.right;
                if (root != null) {
                    root.parent = null;
                }
            } else if (nodeToDelete.right == null) {
                root = nodeToDelete.left;
                root.parent = null;
            } else {
                Node successor = findMin(nodeToDelete.right);
                successor.left = nodeToDelete.left;
                nodeToDelete.left.parent = successor;
                root = nodeToDelete.right;
                root.parent = null;
            }
        }
    }

    
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    
    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
        System.out.println();
    }

    
    private void inOrderTraversalHelper(Node node) {
        if (node != null) {
            inOrderTraversalHelper(node.left);
            System.out.print(node.key + " ");
            inOrderTraversalHelper(node.right);
        }
    }

    public static void main(String[] args) {
        SplayTree splayTree = new SplayTree();

        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(3);
        splayTree.insert(7);

        System.out.println("In-order traversal before search:");
        splayTree.inOrderTraversal();

        boolean found = splayTree.search(5);
        System.out.println("Search for key 5: " + found);

        System.out.println("In-order traversal after search (5 should be at the root):");
        splayTree.inOrderTraversal();

        splayTree.delete(7);

        System.out.println("In-order traversal after deletion of key 7:");
        splayTree.inOrderTraversal();
    }
}
