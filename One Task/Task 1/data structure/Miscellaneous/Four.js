// Implement an algorithm to find the kth smallest/largest element in an array

let arr = [56, 78, 34, 90, 45];

arr = arr.sort();

console.log(arr);

// kth slowest
let ks = 2;
console.log(arr[ks-1]);

// kth largest
let kl = 2;
console.log(arr[arr.length - kl]);