class Node {
    constructor(key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class AVLTree {
    constructor() {
        this.root = null;
    }

    height(node) {
        return node ? node.height : 0;
    }

    balanceFactor(node) {
        return this.height(node.left) - this.height(node.right);
    }

    updateHeight(node) {
        node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
    }

    rotateRight(y) {
        const x = y.left;
        const T2 = x.right;

        x.right = y;
        y.left = T2;

        this.updateHeight(y);
        this.updateHeight(x);

        return x;
    }

    rotateLeft(x) {
        const y = x.right;
        const T2 = y.left;

        y.left = x;
        x.right = T2;

        this.updateHeight(x);
        this.updateHeight(y);

        return y;
    }

    balance(node) {
        if (!node) return null;

        this.updateHeight(node);

        const balanceFactor = this.balanceFactor(node);

        // Left Heavy
        if (balanceFactor > 1) {
            if (this.balanceFactor(node.left) < 0) {
                node.left = this.rotateLeft(node.left);
            }
            return this.rotateRight(node);
        }

        // Right Heavy
        if (balanceFactor < -1) {
            if (this.balanceFactor(node.right) > 0) {
                node.right = this.rotateRight(node.right);
            }
            return this.rotateLeft(node);
        }

        return node;
    }

    insert(key, root = this.root) {
        if (!root) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = this.insert(key, root.left);
        } else if (key > root.key) {
            root.right = this.insert(key, root.right);
        } else {
            return root; // Duplicate keys are not allowed
        }

        return this.balance(root);
    }

    delete(key, root = this.root) {
        if (!root) {
            return null;
        }

        if (key < root.key) {
            root.left = this.delete(key, root.left);
        } else if (key > root.key) {
            root.right = this.delete(key, root.right);
        } else {
            // Node with only one child or no child
            if (!root.left) {
                return root.right;
            } else if (!root.right) {
                return root.left;
            }

            // Node with two children
            const minValue = this.findMin(root.right);
            root.key = minValue.key;
            root.right = this.delete(minValue.key, root.right);
        }

        return this.balance(root);
    }

    search(key, root = this.root) {
        if (!root || root.key === key) {
            return root;
        }

        if (key < root.key) {
            return this.search(key, root.left);
        }

        return this.search(key, root.right);
    }

    findMin(root) {
        while (root.left) {
            root = root.left;
        }
        return root;
    }
}

// Example usage:

const avlTree = new AVLTree();

avlTree.root = avlTree.insert(10);
avlTree.root = avlTree.insert(20);
avlTree.root = avlTree.insert(30);

console.log("AVL Tree after insertion:");
console.log(avlTree.root);

avlTree.root = avlTree.delete(20);

console.log("AVL Tree after deletion:");
console.log(avlTree.root);

const searchResult = avlTree.search(10);
console.log("Search result:", searchResult);
