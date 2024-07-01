class IntervalTree {
    constructor(start, end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }

    static build(intervals) {
        if (!intervals || intervals.length === 0) {
            return null;
        }

        const sortedIntervals = intervals.sort((a, b) => a.start - b.start);
        const middle = Math.floor(sortedIntervals.length / 2);

        const root = new IntervalTree(sortedIntervals[middle].start, sortedIntervals[middle].end);
        root.left = IntervalTree.build(sortedIntervals.slice(0, middle));
        root.right = IntervalTree.build(sortedIntervals.slice(middle + 1));

        return root;
    }

    insert(interval) {
        if (interval.start < this.start) {
            if (this.left) {
                this.left.insert(interval);
            } else {
                this.left = new IntervalTree(interval.start, interval.end);
            }
        } else {
            if (this.right) {
                this.right.insert(interval);
            } else {
                this.right = new IntervalTree(interval.start, interval.end);
            }
        }
    }

    search(interval) {
        if (this.start <= interval.end && this.end >= interval.start) {
            return true;
        } else if (this.left && interval.start < this.start) {
            return this.left.search(interval);
        } else if (this.right && interval.start > this.start) {
            return this.right.search(interval);
        }

        return false;
    }
}

function areRectanglesOverlap(rect1, rect2) {
    const intervalTree = IntervalTree.build([
        { start: rect1.x, end: rect1.x + rect1.width },
        { start: rect2.x, end: rect2.x + rect2.width }
    ]);

    return intervalTree.search({ start: rect2.x, end: rect2.x + rect2.width }) &&
           intervalTree.search({ start: rect1.y, end: rect1.y + rect1.height }) &&
           intervalTree.search({ start: rect2.y, end: rect2.y + rect2.height });
}

// Example usage:
const rectangle1 = { x: 0, y: 0, width: 4, height: 3 };
const rectangle2 = { x: 2, y: 1, width: 3, height: 4 };

const overlap = areRectanglesOverlap(rectangle1, rectangle2);
console.log(overlap); // Should print: true
