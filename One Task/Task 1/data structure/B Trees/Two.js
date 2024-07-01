class BPlusTreeNode {
    constructor(order, isLeaf = true) {
        this.keys = [];
        this.children = [];
        this.isLeaf = isLeaf;
        this.order = order; // Order of the B+ tree
    }
}

class BPlusTree {
    constructor(order) {
        this.root = null;
        this.order = order;
    }

    search(key) {
        return this.searchInNode(this.root, key);
    }

    searchInNode(node, key) {
        if (!node) {
            return false;
        }

        let i = 0;
        while (i < node.keys.length && key > node.keys[i]) {
            i++;
        }

        if (node.isLeaf) {
            return i < node.keys.length && key === node.keys[i];
        } else {
            return this.searchInNode(node.children[i], key);
        }
    }

    insert(key) {
        if (!this.root) {
            this.root = new BPlusTreeNode(this.order, true);
            this.root.keys.push(key);
        } else {
            if (this.root.keys.length === this.order - 1) {
                let newRoot = new BPlusTreeNode(this.order, false);
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
            if (node.children[i].keys.length === this.order - 1) {
                this.splitChild(node, i);
                if (key > node.keys[i]) {
                    i++;
                }
            }

            this.insertNonFull(node.children[i], key);
        }
    }

    splitChild(parent, index) {
        let order = this.order;
        let child = parent.children[index];
        let newChild = new BPlusTreeNode(order, child.isLeaf);
        parent.children.splice(index + 1, 0, newChild);
        parent.keys.splice(index, 0, child.keys[Math.floor(order / 2)]);

        newChild.keys = child.keys.splice(Math.ceil(order / 2));
        if (!child.isLeaf) {
            newChild.children = child.children.splice(Math.ceil(order / 2));
        }
    }
}

// Example usage:
const bPlusTree = new BPlusTree(3);

bPlusTree.insert(10);
bPlusTree.insert(20);
bPlusTree.insert(5);
bPlusTree.insert(6);
bPlusTree.insert(12);

console.log(bPlusTree.search(6)); // Should print: true
console.log(bPlusTree.search(15)); // Should print: false
