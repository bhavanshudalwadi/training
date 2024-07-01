class Queue {
    constructor() {
        this.items = [];
    }

    enqueue(item) {
        this.items.push(item);
    }

    dequeue() {
        return this.items.shift();
    }

    isEmpty() {
        return this.items.length === 0;
    }
}

function shortestPathInMaze(maze, start, destination) {
    const rows = maze.length;
    const cols = maze[0].length;
    const queue = new Queue();
    const visited = new Set();

    const directions = [
        [-1, 0], // Up
        [1, 0],  // Down
        [0, -1], // Left
        [0, 1]   // Right
    ];

    queue.enqueue({ position: start, distance: 0 });
    visited.add(`${start[0]},${start[1]}`);

    while (!queue.isEmpty()) {
        const { position, distance } = queue.dequeue();

        if (position[0] === destination[0] && position[1] === destination[1]) {
            return distance; // Shortest path found
        }

        for (const direction of directions) {
            const newRow = position[0] + direction[0];
            const newCol = position[1] + direction[1];

            if (
                newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols &&
                maze[newRow][newCol] === 0 &&
                !visited.has(`${newRow},${newCol}`)
            ) {
                queue.enqueue({ position: [newRow, newCol], distance: distance + 1 });
                visited.add(`${newRow},${newCol}`);
            }
        }
    }

    return -1; // No valid path found
}

// Example usage:

const maze = [
    [0, 1, 0, 0, 0],
    [0, 1, 0, 1, 0],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 0, 0],
    [0, 0, 0, 1, 0]
];

const start = [0, 0];
const destination = [4, 4];

const shortestPath = shortestPathInMaze(maze, start, destination);

if (shortestPath !== -1) {
    console.log(`Shortest path from ${start} to ${destination} is ${shortestPath} steps.`);
} else {
    console.log("No valid path found.");
}
