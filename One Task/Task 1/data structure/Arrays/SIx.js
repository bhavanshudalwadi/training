var arr = [1, 2, 2, 1, 2, 2];
arr = arr.sort();
console.log(arr.filter((item, pos) => arr.indexOf(item) == pos));