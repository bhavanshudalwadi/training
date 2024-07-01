class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function isBalanced(root) {
    // Helper function to calculate the height of a subtree
    function getHeight(node) {
        if (node === null) {
            return 0;
        }

        const leftHeight = getHeight(node.left);
        if (leftHeight === -1) {
            return -1; // Left subtree is unbalanced, propagate the result up
        }

        const rightHeight = getHeight(node.right);
        if (rightHeight === -1) {
            return -1; // Right subtree is unbalanced, propagate the result up
        }

        // Check if the current subtree is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Subtree is unbalanced, propagate the result up
        }

        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Start the recursive calculation from the root
    return getHeight(root) !== -1;
}

// Example usage:

// Construct a balanced binary tree
const balancedRoot = new TreeNode(1);
balancedRoot.left = new TreeNode(2);
balancedRoot.right = new TreeNode(3);
balancedRoot.left.left = new TreeNode(4);
balancedRoot.left.right = new TreeNode(5);

console.log("Is the Balanced Tree balanced?", isBalanced(balancedRoot));

// Construct an unbalanced binary tree
const unbalancedRoot = new TreeNode(1);
unbalancedRoot.left = new TreeNode(2);
unbalancedRoot.right = new TreeNode(3);
unbalancedRoot.left.left = new TreeNode(4);
unbalancedRoot.left.left.left = new TreeNode(5);

console.log("Is the Unbalanced Tree balanced?", isBalanced(unbalancedRoot));
