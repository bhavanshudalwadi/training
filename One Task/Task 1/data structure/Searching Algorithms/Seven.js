class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function bfs(root) {
    const result = [];
    if (!root) {
        return result;
    }

    const queue = [root];

    while (queue.length > 0) {
        const current = queue.shift(); // Dequeue the front node
        result.push(current.value);

        if (current.left) {
            queue.push(current.left); // Enqueue the left child
        }

        if (current.right) {
            queue.push(current.right); // Enqueue the right child
        }
    }

    return result;
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

// Perform breadth-first search
const result = bfs(root);

console.log("BFS in Binary Search Tree:", result);
