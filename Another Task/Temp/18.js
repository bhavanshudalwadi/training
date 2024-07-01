const findMedianSortedArrays = (nums1, nums2) => {
    const merged = [...nums1, ...nums2].sort();
    const mid = Math.floor(merged.length / 2);

    if (merged.length % 2 === 0) {
        return (merged[mid - 1] + merged[mid]) / 2;
    } else {
        return merged[mid];
    }
};

let arr1 = [67, 89, 29];
let arr2 = [10, 38, 11];

console.log(`Median of Arrays: ${findMedianSortedArrays(arr1, arr2)}`);