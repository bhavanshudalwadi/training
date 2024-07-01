function orientation(p, q, r) {
    const val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

    if (val === 0) return 0; // Collinear
    return (val > 0) ? 1 : 2; // Clockwise or Counterclockwise
}

function grahamScan(points) {
    if (points.length < 3) return [];

    const n = points.length;

    // Find the point with the lowest y-coordinate (and leftmost if there are ties)
    let minY = Infinity;
    let minIdx = -1;
    for (let i = 0; i < n; i++) {
        if (points[i].y < minY || (points[i].y === minY && points[i].x < points[minIdx].x)) {
            minY = points[i].y;
            minIdx = i;
        }
    }

    // Swap the lowest point with the first point
    const temp = points[0];
    points[0] = points[minIdx];
    points[minIdx] = temp;

    // Sort the points by polar angle in counterclockwise order
    points.sort((a, b) => {
        const o = orientation(points[0], a, b);
        if (o === 0) return (distance(points[0], b) >= distance(points[0], a)) ? -1 : 1;
        return (o === 2) ? -1 : 1;
    });

    const stack = [points[0], points[1], points[2]];

    for (let i = 3; i < n; i++) {
        while (orientation(stack[stack.length - 2], stack[stack.length - 1], points[i]) !== 2) {
            stack.pop();
        }
        stack.push(points[i]);
    }

    return stack;
}

function distance(p1, p2) {
    return Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2);
}

// Example usage:
const points = [
    { x: 0, y: 3 },
    { x: 1, y: 1 },
    { x: 2, y: 2 },
    { x: 4, y: 4 },
    { x: 0, y: 0 },
    { x: 1, y: 2 },
    { x: 3, y: 1 },
    { x: 3, y: 3 }
];

const convexHull = grahamScan(points);
console.log(convexHull);
