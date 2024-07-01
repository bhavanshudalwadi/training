class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function inOrderTraversal(root) {
    const result = [];
    const stack = [];

    let current = root;

    while (current || stack.length > 0) {
        while (current) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        result.push(current.value);

        current = current.right;
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

// Perform in-order traversal
const result = inOrderTraversal(root);

console.log("In-Order Traversal:", result);


/*
            1
        2       3
    4       5
*/