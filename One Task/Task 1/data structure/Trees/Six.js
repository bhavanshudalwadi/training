class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function findLowestCommonAncestor(root, node1, node2) {
    if (!root) {
        return null; // Empty tree or not found
    }

    if (root.value === node1 || root.value === node2) {
        return root; // Node1 or Node2 found at the current root
    }

    const leftLCA = findLowestCommonAncestor(root.left, node1, node2);
    const rightLCA = findLowestCommonAncestor(root.right, node1, node2);

    // If both left and right subtrees have an LCA, then the current root is the LCA
    if (leftLCA && rightLCA) {
        return root;
    }

    // Otherwise, return the non-null result (if any) from left or right subtree
    return leftLCA || rightLCA;
}

// Example usage:

// Construct a binary tree
const root = new TreeNode(3);
root.left = new TreeNode(5);
root.right = new TreeNode(1);
root.left.left = new TreeNode(6);
root.left.right = new TreeNode(2);
root.right.left = new TreeNode(0);
root.right.right = new TreeNode(8);
root.left.right.left = new TreeNode(7);
root.left.right.right = new TreeNode(4);

const node1 = 5;
const node2 = 1;

// Find the lowest common ancestor
const lca = findLowestCommonAncestor(root, node1, node2);

console.log(`Lowest Common Ancestor of ${node1} and ${node2} is: ${lca ? lca.value : "Not found"}`);
