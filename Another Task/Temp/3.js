function findNormalAndTrace(matrix) {
  let normal = 0;
  let trace = 0;

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix.length; j++) {
      normal += Math.pow(matrix[i][j], 2);
      if (i === j) {
        trace += matrix[i][j];
      }
    }
  }

  normal = Math.sqrt(normal);

  return { normal, trace };
}

const squareMatrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];

const { normal, trace } = findNormalAndTrace(squareMatrix);

console.log(`Normal: ${normal}`);
console.log(`Trace: ${trace}`);


// Normal = Math.sqrt(1*1 + 2*2 + 3*3 + 4*4 + 5*5 + 6*6 + 7*7 + 8*8 + 9*9);     => Sqrt of Sum of Products
// Trace = Math.sqrt(1 + 5 + 9);    => Sum of Diagonal