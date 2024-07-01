class TreeNode {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function areIdenticalTrees(root1, root2) {
    // Base cases: If both trees are empty, they are identical
    if (!root1 && !root2) {
        return true;
    }

    // If one tree is empty and the other is not, they are not identical
    if (!root1 || !root2) {
        return false;
    }

    // Check if the current nodes have the same value and recursively check their subtrees
    return (
        root1.value === root2.value &&
        areIdenticalTrees(root1.left, root2.left) &&
        areIdenticalTrees(root1.right, root2.right)
    );
}

// Example usage:

// Construct two identical trees
const tree1 = new TreeNode(1);
tree1.left = new TreeNode(2);
tree1.right = new TreeNode(3);
tree1.left.left = new TreeNode(4);
tree1.left.right = new TreeNode(5);

const tree2 = new TreeNode(1);
tree2.left = new TreeNode(2);
tree2.right = new TreeNode(3);
tree2.left.left = new TreeNode(4);
tree2.left.right = new TreeNode(5);

console.log("Are the trees identical?", areIdenticalTrees(tree1, tree2));

// Construct two non-identical trees
const tree3 = new TreeNode(1);
tree3.left = new TreeNode(2);
tree3.right = new TreeNode(3);

const tree4 = new TreeNode(1);
tree4.left = new TreeNode(2);
tree4.right = new TreeNode(4);

console.log("Are the trees identical?", areIdenticalTrees(tree3, tree4));
