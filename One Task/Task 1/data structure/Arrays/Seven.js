var arr1 = [34, 56, 78, 28, 90], arr2 = [78, 67, 45, 28, 39];

arr1 = arr1.sort();
arr2 = arr2.sort();

var newArr = arr1.concat(arr2);

console.log(newArr.filter((item, index) => newArr.indexOf(item) === index));