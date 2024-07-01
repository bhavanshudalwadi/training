function calculateFactorial(num) {
    if (num === 0 || num === 1) {
        return 1;
    } else {
        return num * calculateFactorial(num - 1);
    }
}

function calculatePermutation(n, r) {
    return calculateFactorial(n) / calculateFactorial(n - r);
}

function calculateCombination(n, r) {
    return calculateFactorial(n) / (calculateFactorial(r) * calculateFactorial(n - r));
}

const n = 5;
const r = 2;

const permutationResult = calculatePermutation(n, r);
const combinationResult = calculateCombination(n, r);

console.log(`Permutation (${n}P${r}): ${permutationResult}`);
console.log(`Combination (${n}C${r}): ${combinationResult}`);

// Parmutation Formula nPr = n! / n-r!
// Combination Formula nCr = n! / r! * (n-r!)
