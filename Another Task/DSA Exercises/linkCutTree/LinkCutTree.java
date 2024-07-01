package linkCutTree;

import java.util.Random;

class Node {
    Node parent, left, right;
    boolean isRoot, isReversed;
    int value, size;

    public Node(int value) {
        this.value = value;
        this.size = 1;
        this.isReversed = false;
        this.isRoot = true;
    }
}

public class LinkCutTree {
    // Perform a rotation (either zig or zig-zig) to move x up in the tree
    private void rotate(Node x) {
        Node p = x.parent;
        Node g = p.parent;

        if (!p.isRoot) {
            if ((p.left == x) == (g.left == p)) {
                // Zig-Zig
                rotate(p);
            } else {
                // Zig
                if (p.left == x) rotateLeft(x);
                else rotateRight(x);
            }
        }

        // Zig-Zig
        if (x.left == p) rotateRight(x);
        else rotateLeft(x);
    }

    // Rotate the edge between x and its parent to the left
    private void rotateLeft(Node x) {
        Node p = x.parent;
        Node g = p.parent;

        p.right = x.left;
        if (x.left != null) x.left.parent = p;

        x.left = p;
        p.parent = x;

        update(p);
        update(x);

        if (p.isRoot) {
            x.isRoot = true;
            x.parent = null;
        } else {
            if (g.left == p) g.left = x;
            else g.right = x;
            x.parent = g;
        }
    }

    // Rotate the edge between x and its parent to the right
    private void rotateRight(Node x) {
        Node p = x.parent;
        Node g = p.parent;

        p.left = x.right;
        if (x.right != null) x.right.parent = p;

        x.right = p;
        p.parent = x;

        update(p);
        update(x);

        if (p.isRoot) {
            x.isRoot = true;
            x.parent = null;
        } else {
            if (g.left == p) g.left = x;
            else g.right = x;
            x.parent = g;
        }
    }

    // Update the size of a node based on its children
    private void update(Node x) {
        x.size = 1 + getSize(x.left) + getSize(x.right);
    }

    // Get the size of a node (null-safe)
    private int getSize(Node x) {
        return (x != null) ? x.size : 0;
    }

    // Access operation: Splay the node x to the root of its represented tree
    private void access(Node x) {
        splay(x);
        x.right = null;

        while (x.parent != null) {
            Node p = x.parent;
            splay(p);
            p.right = x;
            update(p);
            x.parent = null;
            x.isRoot = true;
            x = p;
        }
    }

    // Make x the root of its represented tree and set its right child to y
    private void link(Node x, Node y) {
        access(y);
        splay(y);
        splay(x);
        y.right = x;
        x.parent = y;
        update(y);
    }

    // Cut the edge between x and its parent
    private void cut(Node x) {
        access(x);
        splay(x);
        x.left.parent = null;
        x.left = null;
        update(x);
    }

    // Splay operation: Move the node x to the root of its represented tree
    private void splay(Node x) {
        while (!x.isRoot) {
            Node p = x.parent;
            Node g = p.parent;

            if (!p.isRoot) {
                if ((p.left == x) == (g.left == p)) {
                    rotate(p);
                } else {
                    if (p.left == x) rotateRight(x);
                    else rotateLeft(x);
                }
            }

            if (!x.isRoot) {
                if (x.parent.left == x) rotateRight(x);
                else rotateLeft(x);
            }
        }
    }

    public static void main(String[] args) {
        LinkCutTree lct = new LinkCutTree();

        Node[] nodes = new Node[5];
        for (int i = 0; i < 5; i++) {
            nodes[i] = new Node(i);
        }

        lct.link(nodes[1], nodes[0]);
        lct.link(nodes[2], nodes[0]);
        lct.link(nodes[3], nodes[2]);
        lct.link(nodes[4], nodes[1]);

        // Cut the edge between nodes[1] and its parent
        lct.cut(nodes[1]);

        // Link nodes[1] to nodes[3]
        lct.link(nodes[1], nodes[3]);
    }
}

