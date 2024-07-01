function calculateCubeVolume(sideLength) {
    return Math.pow(sideLength, 3);
}

const side = 4;

const volume = calculateCubeVolume(side);
console.log("Cube Volume:", volume);