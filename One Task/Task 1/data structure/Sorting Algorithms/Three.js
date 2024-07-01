// Insertion Sort

let a = [5,4,3,2,1];
// let a = [1,2,3,4,5];

const printArray = (arr) => {
    console.log(arr);
}

for(var i=0; i<a.length; i++) {
    for(var j=0; j<=i; j++) {
        printArray(a);
        if(a[j] > a[i]) {
            var temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    console.log("\n");
}