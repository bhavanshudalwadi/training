class Interval {
    constructor(start, end) {
        this.start = start;
        this.end = end;
    }
}

function findOverlappingIntervals(intervals) {
    if (!intervals || intervals.length < 2) {
        return [];
    }

    intervals.sort((a, b) => a.start - b.start);

    const result = [];
    let currentInterval = intervals[0];

    for (let i = 1; i < intervals.length; i++) {
        const nextInterval = intervals[i];

        if (currentInterval.end >= nextInterval.start) {
            // Overlapping intervals found
            result.push([currentInterval, nextInterval]);
        }

        // Update currentInterval to the one with the larger end time
        currentInterval = (currentInterval.end >= nextInterval.end) ? currentInterval : nextInterval;
    }

    return result;
}

function areRectanglesOverlap(rect1, rect2) {
    return (
        rect1.x < rect2.x + rect2.width &&
        rect1.x + rect1.width > rect2.x &&
        rect1.y < rect2.y + rect2.height &&
        rect1.y + rect1.height > rect2.y
    );
}

// Example usage:
const intervals = [
    new Interval(1, 5),
    new Interval(3, 7),
    new Interval(4, 8),
    new Interval(10, 15)
];

const overlappingIntervals = findOverlappingIntervals(intervals);
console.log("Overlapping Intervals:", overlappingIntervals);

const rectangle1 = { x: 0, y: 0, width: 4, height: 3 };
const rectangle2 = { x: 2, y: 1, width: 3, height: 4 };

const rectanglesOverlap = areRectanglesOverlap(rectangle1, rectangle2);
console.log("Rectangles Overlap:", rectanglesOverlap);
