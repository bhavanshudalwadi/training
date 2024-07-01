class SegmentTree {
    constructor(arr) {
        this.tree = new Array(2 * arr.length).fill(0);
        this.constructSegmentTree(arr, 0, arr.length - 1, 0);
    }

    constructSegmentTree(arr, start, end, treeNode) {
        if (start === end) {
            this.tree[treeNode] = arr[start];
            return;
        }

        const mid = Math.floor((start + end) / 2);
        this.constructSegmentTree(arr, start, mid, 2 * treeNode + 1);
        this.constructSegmentTree(arr, mid + 1, end, 2 * treeNode + 2);

        this.tree[treeNode] = this.tree[2 * treeNode + 1] + this.tree[2 * treeNode + 2];
    }

    query(start, end, queryStart, queryEnd, treeNode) {
        // Total overlap
        if (start >= queryStart && end <= queryEnd) {
            return this.tree[treeNode];
        }

        // No overlap
        if (end < queryStart || start > queryEnd) {
            return 0;
        }

        // Partial overlap, recur for both left and right subtrees
        const mid = Math.floor((start + end) / 2);
        const leftSum = this.query(start, mid, queryStart, queryEnd, 2 * treeNode + 1);
        const rightSum = this.query(mid + 1, end, queryStart, queryEnd, 2 * treeNode + 2);

        return leftSum + rightSum;
    }
}

// Example usage:

const inputArray = [1, 3, 5, 7, 9, 11];
const segmentTree = new SegmentTree(inputArray);

console.log("Original Array:", inputArray);
console.log("Segment Tree:", segmentTree.tree);

console.log("Query [1, 4]:", segmentTree.query(0, inputArray.length - 1, 1, 4, 0)); // Sum of elements from index 1 to 4
console.log("Query [2, 5]:", segmentTree.query(0, inputArray.length - 1, 2, 5, 0)); // Sum of elements from index 2 to 5
