// Rotate array by k position

var arr1 = [34, 56, 12, 78, 45], arr2 = [], k = 2;

for(var i=0; i<arr1.length; i++, k++) {
    if(k == arr1.length) {
        k = 0;
    }
    arr2[k] = arr1[i];
}
console.log(arr2);