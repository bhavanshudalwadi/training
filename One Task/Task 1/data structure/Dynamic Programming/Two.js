
let a = [10, 22, 9, 33, 21, 50, 41, 60, 80], n = 9, k = 2;
let res = new Array(n).fill(0);

let max = a[0];
res[0] = 1;

for(let i=1; i<n; i++) {
    if(a[i] > max) {
        max = a[i];
        res[i] = k++;
    }
}

console.log(Math.max(...res));