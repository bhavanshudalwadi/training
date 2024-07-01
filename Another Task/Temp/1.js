function calculateSum(array, k) {

  if (k > array.length) {
    console.log("Error: k is greater than the size of the array.");
    return null;
  }

  let sum = 0;
  for (let i = 0; i < k; i++) {
    sum += array[i];
  }

  return sum;
}

const k = 5;
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const result = calculateSum(arr, k);

if (result !== null) {
  console.log(`The sum of the first ${k} elements is: ${result}`);
} else {
  console.log(`k is invalid`);
}
