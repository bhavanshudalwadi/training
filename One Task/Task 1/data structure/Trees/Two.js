class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function findHeight(root) {
    if (root === null) {
        return -1; // Height of an empty tree is -1
    }

    const leftHeight = findHeight(root.left);
    const rightHeight = findHeight(root.right);

    // Height of the tree is the maximum height of left and right subtrees, plus 1 for the current level
    return Math.max(leftHeight, rightHeight) + 1;
}

// Example usage:

// Construct a simple binary tree
const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);

// Find and print the height of the binary tree
const treeHeight = findHeight(root);
console.log("Height of the Binary Tree:", treeHeight);
