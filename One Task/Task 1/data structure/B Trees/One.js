class BTreeNode {
    constructor(t, isLeaf = true) {
        this.keys = [];
        this.children = [];
        this.isLeaf = isLeaf;
        this.t = t; // Minimum degree
    }
}

class BTree {
    constructor(t) {
        this.root = null;
        this.t = t; // Minimum degree
    }

    search(node, key) {
        let i = 0;
        while (i < node.keys.length && key > node.keys[i]) {
            i++;
        }

        if (i < node.keys.length && key === node.keys[i]) {
            return true; // Key found
        } else if (node.isLeaf) {
            return false; // Key not found in a leaf node
        } else {
            return this.search(node.children[i], key); // Recursively search in the appropriate child
        }
    }

    insert(key) {
        if (!this.root) {
            this.root = new BTreeNode(this.t, true);
            this.root.keys.push(key);
        } else {
            if (this.root.keys.length === (2 * this.t) - 1) {
                let newRoot = new BTreeNode(this.t, false);
                newRoot.children.push(this.root);
                this.splitChild(newRoot, 0);
                this.root = newRoot;
            }
            this.insertNonFull(this.root, key);
        }
    }

    insertNonFull(node, key) {
        let i = node.keys.length - 1;

        if (node.isLeaf) {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            node.keys.splice(i + 1, 0, key);
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }

            i++;
            if (node.children[i].keys.length === (2 * this.t) - 1) {
                this.splitChild(node, i);
                if (key > node.keys[i]) {
                    i++;
                }
            }

            this.insertNonFull(node.children[i], key);
        }
    }

    splitChild(parent, index) {
        let t = this.t;
        let child = parent.children[index];
        let newChild = new BTreeNode(t, child.isLeaf);
        parent.children.splice(index + 1, 0, newChild);
        parent.keys.splice(index, 0, child.keys[t - 1]);

        newChild.keys = child.keys.splice(t);
        if (!child.isLeaf) {
            newChild.children = child.children.splice(t);
        }
    }

    // Other methods for deletion, merging, borrowing, etc., would be added here
}

// Example usage:
const bTree = new BTree(2);

bTree.insert(10);
bTree.insert(20);
bTree.insert(5);
bTree.insert(6);
bTree.insert(12);

console.log(bTree.search(bTree.root, 6)); // Should print: true
console.log(bTree.search(bTree.root, 15)); // Should print: false
