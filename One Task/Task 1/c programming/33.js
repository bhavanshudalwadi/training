// Bubble Sort

let a = [5,4,3,2,1];
// let a = [1,2,3,4,5];

const printArray = (arr) => {
    console.log(arr);
}

for(var i=0; i<a.length; i++) {
    for(var j=0; j<a.length-i; j++) {
        printArray(a);
        if(a[j+1] < a[j]) {
            var temp = a[j];
            a[j] = a[j+1];
            a[j+1] = temp;
        }
    }
    console.log("\n");
}