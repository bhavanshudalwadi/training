class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

class QuadtreeNode {
    constructor(x, y, width, height, capacity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.capacity = capacity;
        this.points = [];
        this.isDivided = false;
        this.northwest = null;
        this.northeast = null;
        this.southwest = null;
        this.southeast = null;
    }

    insert(point) {
        if (!this.isInBounds(point)) {
            return false;
        }

        if (this.points.length < this.capacity) {
            this.points.push(point);
            return true;
        } else {
            if (!this.isDivided) {
                this.subdivide();
            }

            if (this.northwest.insert(point)) return true;
            if (this.northeast.insert(point)) return true;
            if (this.southwest.insert(point)) return true;
            if (this.southeast.insert(point)) return true;
        }
        return false;
    }

    query(range, foundPoints) {
        if (!this.intersects(range)) {
            return;
        }

        for (let point of this.points) {
            if (this.isInsideRange(point, range)) {
                foundPoints.push(point);
            }
        }

        if (this.isDivided) {
            this.northwest.query(range, foundPoints);
            this.northeast.query(range, foundPoints);
            this.southwest.query(range, foundPoints);
            this.southeast.query(range, foundPoints);
        }
    }

    isInBounds(point) {
        return (
            point.x >= this.x &&
            point.x <= this.x + this.width &&
            point.y >= this.y &&
            point.y <= this.y + this.height
        );
    }

    intersects(range) {
        return !(
            range.x > this.x + this.width ||
            range.x + range.width < this.x ||
            range.y > this.y + this.height ||
            range.y + range.height < this.y
        );
    }

    isInsideRange(point, range) {
        return (
            point.x >= range.x &&
            point.x <= range.x + range.width &&
            point.y >= range.y &&
            point.y <= range.y + range.height
        );
    }

    subdivide() {
        let halfWidth = this.width / 2;
        let halfHeight = this.height / 2;
        let xMid = this.x + halfWidth;
        let yMid = this.y + halfHeight;

        this.northwest = new QuadtreeNode(this.x, this.y, halfWidth, halfHeight, this.capacity);
        this.northeast = new QuadtreeNode(xMid, this.y, halfWidth, halfHeight, this.capacity);
        this.southwest = new QuadtreeNode(this.x, yMid, halfWidth, halfHeight, this.capacity);
        this.southeast = new QuadtreeNode(xMid, yMid, halfWidth, halfHeight, this.capacity);
        this.isDivided = true;
    }
}

class Quadtree {
    constructor(x, y, width, height, capacity) {
        this.root = new QuadtreeNode(x, y, width, height, capacity);
    }

    insert(point) {
        return this.root.insert(point);
    }

    query(range) {
        let foundPoints = [];
        this.root.query(range, foundPoints);
        return foundPoints;
    }
}

// Example usage:
const quadtree = new Quadtree(0, 0, 100, 100, 4);

quadtree.insert(new Point(10, 20));
quadtree.insert(new Point(30, 40));
quadtree.insert(new Point(70, 80));

const range = { x: 0, y: 0, width: 50, height: 50 };
const result = quadtree.query(range);

console.log(result); // Should print: [ Point { x: 10, y: 20 }, Point { x: 30, y: 40 } ]
