class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function levelOrderTraversal(root) {
    if (!root) {
        return [];
    }

    const result = [];
    const queue = [root];

    while (queue.length > 0) {
        const node = queue.shift(); // Dequeue the front node

        result.push(node.value); // Process the current node

        if (node.left) {
            queue.push(node.left); // Enqueue the left child
        }

        if (node.right) {
            queue.push(node.right); // Enqueue the right child
        }
    }

    return result;
}

// Example usage:

// Construct a binary tree
const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);

// Perform level-order traversal
const result = levelOrderTraversal(root);

console.log("Level-Order Traversal:", result);
