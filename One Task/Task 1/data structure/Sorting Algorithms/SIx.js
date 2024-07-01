let arr = [78, 45, 38, 90, 19];

for (var i = 0; i < arr.length; i++) {
    let max = 0;
    for (let j = 0; j < arr.length - i; j++) {
        if (arr[j] > arr[max]) {
            max = j;
        }
    }

    let temp = arr[arr.length - i - 1];
    arr[arr.length - i - 1] = arr[max];
    arr[max] = temp;

    console.log(arr);
}

/*
    78, 45, 38, 90, 19
    78, 45, 38, 19, 90
    19, 45, 38, 78, 90
    19, 38, 45, 78, 90
    19, 38, 45, 78, 90
    19, 38, 45, 78, 90
*/