class TreeNode {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

function sortedArrayToBST(nums) {
    if (nums.length === 0) {
        return null;
    }

    const midIndex = Math.floor(nums.length / 2);
    const root = new TreeNode(nums[midIndex]);

    root.left = sortedArrayToBST(nums.slice(0, midIndex));
    root.right = sortedArrayToBST(nums.slice(midIndex + 1));

    return root;
}

// Function to perform an in-order traversal of the BST
function inOrderTraversal(root) {
    if (root) {
        inOrderTraversal(root.left);
        console.log(root.val);
        inOrderTraversal(root.right);
    }
}

// Example usage:

const sortedArray = [1, 2, 3, 4, 5, 6, 7];
const balancedBST = sortedArrayToBST(sortedArray);

console.log("In-order traversal of the balanced BST:");
inOrderTraversal(balancedBST);
