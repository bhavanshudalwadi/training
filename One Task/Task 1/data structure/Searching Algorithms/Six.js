class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function dfsInOrder(node, result = []) {
    if (node !== null) {
        dfsInOrder(node.left, result);
        result.push(node.value);
        dfsInOrder(node.right, result);
    }
}

function dfsPreOrder(node, result = []) {
    if (node !== null) {
        result.push(node.value);
        dfsPreOrder(node.left, result);
        dfsPreOrder(node.right, result);
    }
}

function dfsPostOrder(node, result = []) {
    if (node !== null) {
        dfsPostOrder(node.left, result);
        dfsPostOrder(node.right, result);
        result.push(node.value);
    }
}

// Example usage:

// Construct a binary search tree
const root = new TreeNode(5);
root.left = new TreeNode(3);
root.right = new TreeNode(8);
root.left.left = new TreeNode(2);
root.left.right = new TreeNode(4);
root.right.left = new TreeNode(7);
root.right.right = new TreeNode(9);

console.log("DFS In-Order:");
const inOrderResult = [];
dfsInOrder(root, inOrderResult);
console.log(inOrderResult);

console.log("\nDFS Pre-Order:");
const preOrderResult = [];
dfsPreOrder(root, preOrderResult);
console.log(preOrderResult);

console.log("\nDFS Post-Order:");
const postOrderResult = [];
dfsPostOrder(root, postOrderResult);
console.log(postOrderResult);
