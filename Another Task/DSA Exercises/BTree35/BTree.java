package BTree35;

import java.util.ArrayList;
import java.util.List;

class BTreeNode {
    boolean leaf;
    List<Integer> keys;
    List<BTreeNode> children;

    BTreeNode(boolean leaf) {
        this.leaf = leaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}

public class BTree {
    private BTreeNode root;
    private int t; 

    public BTree(int t) {
        this.root = new BTreeNode(true);
        this.t = t;
    }

    public void insert(int key) {
        BTreeNode r = root;
        if (r.keys.size() == (2 * t - 1)) {
            BTreeNode s = new BTreeNode(false);
            root = s;
            s.children.add(r);
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(BTreeNode x, int key) {
        int i = x.keys.size() - 1;
        if (x.leaf) {
            x.keys.add(0);
            while (i >= 0 && key < x.keys.get(i)) {
                x.keys.set(i + 1, x.keys.get(i));
                i--;
            }
            x.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key < x.keys.get(i)) {
                i--;
            }
            i++;
            if (x.children.get(i).keys.size() == (2 * t - 1)) {
                splitChild(x, i);
                if (key > x.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(x.children.get(i), key);
        }
    }

    private void splitChild(BTreeNode x, int i) {
        BTreeNode y = x.children.get(i);
        BTreeNode z = new BTreeNode(y.leaf);
        x.children.add(i + 1, z);
        x.keys.add(i, y.keys.get(t - 1));
        z.keys.addAll(y.keys.subList(t, 2 * t - 1));
        y.keys.subList(t - 1, 2 * t - 1).clear();
        if (!y.leaf) {
            z.children.addAll(y.children.subList(t, 2 * t));
            y.children.subList(t, 2 * t).clear();
        }
    }

    
    

    public void print() {
        print(root);
    }

    private void print(BTreeNode node) {
        for (int i = 0; i < node.keys.size(); i++) {
            System.out.print(node.keys.get(i) + " ");
        }
        System.out.println();

        if (!node.leaf) {
            for (int i = 0; i < node.children.size(); i++) {
                print(node.children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(2);

        int[] keys = {3, 10, 8, 5, 6, 12, 9, 11, 14, 1, 2, 4, 7, 13, 15};

        for (int key : keys) {
            bTree.insert(key);
        }

        System.out.println("B-Tree structure after insertion:");
        bTree.print();
    }
}
