class Graph {
    constructor() {
        this.vertices = new Map();
    }

    addVertex(vertex) {
        if (!this.vertices.has(vertex)) {
            this.vertices.set(vertex, []);
        }
    }

    addEdge(vertex1, vertex2) {
        if (this.vertices.has(vertex1) && this.vertices.has(vertex2)) {
            this.vertices.get(vertex1).push(vertex2);
            this.vertices.get(vertex2).push(vertex1);
        }
    }

    bfs(startVertex) {
        if (!this.vertices.has(startVertex)) {
            console.log(`Vertex ${startVertex} does not exist.`);
            return;
        }

        const visited = new Set();
        const queue = [];

        queue.push(startVertex);
        visited.add(startVertex);

        while (queue.length > 0) {
            const currentVertex = queue.shift();
            console.log(`Visited: ${currentVertex}`);

            for (const neighbor of this.vertices.get(currentVertex)) {
                if (!visited.has(neighbor)) {
                    queue.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}

// Example usage:

const graph = new Graph();

graph.addVertex('A');
graph.addVertex('B');
graph.addVertex('C');
graph.addVertex('D');
graph.addVertex('E');

graph.addEdge('A', 'B');
graph.addEdge('B', 'C');
graph.addEdge('B', 'D');
graph.addEdge('C', 'E');

console.log("BFS starting from vertex 'A':");
graph.bfs('A');
