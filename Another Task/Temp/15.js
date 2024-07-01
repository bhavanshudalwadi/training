function calculateSphereArea(radius) {
    return 4 * Math.PI * Math.pow(radius, 2);
}

var radius = 5;
var sphereArea = calculateSphereArea(radius);
console.log("Surface Area of Sphere: " + sphereArea.toFixed(2));

// 4*PI*r*r
// toFixed(2) => used to round the function in 2 decimals