class BTreeNode {
    constructor(leaf = true) {
        this.leaf = leaf;
        this.keys = [];
        this.children = [];
    }
}

class BTree {
    constructor(degree) {
        this.root = new BTreeNode();
        this.degree = degree;
    }

    insert(key) {
        let root = this.root;

        if (root.keys.length === 2 * this.degree - 1) {
            let newRoot = new BTreeNode(false);
            newRoot.children.push(this.root);
            this.root = newRoot;
            this.splitChild(newRoot, 0);
            this.insertNonFull(newRoot, key);
        } else {
            this.insertNonFull(root, key);
        }
    }

    insertNonFull(node, key) {
        let i = node.keys.length - 1;

        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }

            node.keys[i + 1] = key;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }

            i++;

            if (node.children[i].keys.length === 2 * this.degree - 1) {
                this.splitChild(node, i);

                if (key > node.keys[i]) {
                    i++;
                }
            }

            this.insertNonFull(node.children[i], key);
        }
    }

    splitChild(parent, index) {
        let degree = this.degree;
        let child = parent.children[index];
        let newChild = new BTreeNode(child.leaf);

        parent.keys.splice(index, 0, child.keys[degree - 1]);
        parent.children.splice(index + 1, 0, newChild);

        newChild.keys = child.keys.slice(degree);
        child.keys = child.keys.slice(0, degree - 1);

        if (!child.leaf) {
            newChild.children = child.children.slice(degree);
            child.children = child.children.slice(0, degree);
        }
    }

    search(key) {
        return this.searchNode(this.root, key);
    }

    searchNode(node, key) {
        let i = 0;
        while (i < node.keys.length && key > node.keys[i]) {
            i++;
        }

        if (i < node.keys.length && key === node.keys[i]) {
            return true;
        } else if (node.leaf) {
            return false;
        } else {
            return this.searchNode(node.children[i], key);
        }
    }
}

const bTree = new BTree(2);

bTree.insert(3);
bTree.insert(7);
bTree.insert(1);
bTree.insert(5);
bTree.insert(10);

console.log(bTree.search(5));
console.log(bTree.search(8));
