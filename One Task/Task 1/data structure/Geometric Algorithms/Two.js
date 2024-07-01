function isOverlap(rect1, rect2) {
    return (
        rect1.x < rect2.x + rect2.width &&
        rect1.x + rect1.width > rect2.x &&
        rect1.y < rect2.y + rect2.height &&
        rect1.y + rect1.height > rect2.y
    );
}

// Example usage:
const rectangle1 = { x: 0, y: 0, width: 4, height: 3 };
const rectangle2 = { x: 2, y: 1, width: 3, height: 4 };

const overlap = isOverlap(rectangle1, rectangle2);
console.log(overlap); // Should print: true
