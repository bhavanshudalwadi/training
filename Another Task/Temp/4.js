function findRoots(a, b, c) {
    const discriminant = b * b - 4 * a * c;

    if (discriminant > 0) {
        const root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        const root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return [root1, root2];
    } else if (discriminant === 0) {
        const root = -b / (2 * a);
        return [root];
    } else {
        const realPart = -b / (2 * a);
        const imaginaryPart = Math.sqrt(Math.abs(discriminant)) / (2 * a);
        return [`${realPart} + ${imaginaryPart}i`, `${realPart} - ${imaginaryPart}i`];
    }
}

const a = 1;
const b = -3;
const c = 2;

const roots = findRoots(a, b, c);

console.log("Roots:", roots);

// Formulas => https://cdn.programiz.com/sites/tutorial2program/files/roots-of-quadratic-equation_0.png