let arr = [78, 45, 38, 90, 19];
let arr2 = new Array(5).fill(0);

for(let i=0; i<2; i++) {
    for(let j=0; j<5; j++) {
        if(i==0) {
            arr2[j] = arr[j] % 10;
        }else if(i==1) {
            arr2[j] = parseInt(arr[j] / 10);
        }
    }

    for(let s=0; s<5; s++) {
        for(let k=s+1; k<5; k++) {
            if(arr2[k] < arr2[s]) {
                let temp2 = arr2[s];
                arr2[s] = arr2[k];
                arr2[k] = temp2;

                let temp = arr[s];
                arr[s] = arr[k];
                arr[k] = temp;
            }
        }
    }
}

console.log(arr);