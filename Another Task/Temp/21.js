function burrowsWheelerTransform(input) {
    var rotations = [];

    for (var i = 0; i < input.length; i++) {
        rotations.push(input.slice(i) + input.slice(0, i));
    }

    rotations.sort();

    var transformedString = rotations.map(rotation => rotation.charAt(rotation.length - 1)).join('');

    var originalIndex = rotations.indexOf(input);

    return { transformedString, originalIndex };
}

function inverseBurrowsWheelerTransform(transformedString, originalIndex) {
    var table = [];

    for (var i = 0; i < transformedString.length; i++) {
        table.push({ char: transformedString[i], index: i });
    }

    table.sort((a, b) => a.char.localeCompare(b.char));

    var originalString = '';
    var currentIndex = originalIndex;
    for (var i = 0; i < transformedString.length; i++) {
        originalString = table[currentIndex].char + originalString;
        currentIndex = table[currentIndex].index;
    }

    return originalString.split('').reverse().join('');
}

var inputString = "banana";
var { transformedString, originalIndex } = burrowsWheelerTransform(inputString);
var originalString = inverseBurrowsWheelerTransform(transformedString, originalIndex);

console.log("Original String:", inputString);
console.log("Transformed String:", transformedString);
console.log("Reconstructed Original String:", originalString);
