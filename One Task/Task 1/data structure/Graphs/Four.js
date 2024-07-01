class Graph {
    constructor() {
        this.vertices = new Map();
    }

    addVertex(vertex) {
        if (!this.vertices.has(vertex)) {
            this.vertices.set(vertex, new Map());
        }
    }

    addEdge(vertex1, vertex2, weight) {
        if (this.vertices.has(vertex1) && this.vertices.has(vertex2)) {
            this.vertices.get(vertex1).set(vertex2, weight);
            this.vertices.get(vertex2).set(vertex1, weight);
        }
    }

    dijkstra(startVertex) {
        if (!this.vertices.has(startVertex)) {
            console.log(`Vertex ${startVertex} does not exist.`);
            return;
        }

        const distance = new Map();
        const visited = new Set();
        const priorityQueue = [];

        // Initialize distances with Infinity, except for the start vertex with distance 0
        for (const vertex of this.vertices.keys()) {
            distance.set(vertex, vertex === startVertex ? 0 : Infinity);
            priorityQueue.push({ vertex, distance: distance.get(vertex) });
        }

        while (priorityQueue.length > 0) {
            priorityQueue.sort((a, b) => a.distance - b.distance);
            const { vertex: currentVertex, distance: currentDistance } = priorityQueue.shift();

            if (visited.has(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            for (const [neighbor, weight] of this.vertices.get(currentVertex).entries()) {
                const newDistance = currentDistance + weight;

                if (newDistance < distance.get(neighbor)) {
                    distance.set(neighbor, newDistance);
                    priorityQueue.push({ vertex: neighbor, distance: newDistance });
                }
            }
        }

        console.log("Shortest distances from vertex", startVertex);
        for (const [vertex, dist] of distance.entries()) {
            console.log(`${vertex}: ${dist === Infinity ? 'Infinity' : dist}`);
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

graph.addEdge('A', 'B', 2);
graph.addEdge('B', 'C', 1);
graph.addEdge('A', 'D', 5);
graph.addEdge('D', 'E', 3);
graph.addEdge('B', 'D', 2);
graph.addEdge('C', 'E', 4);
graph.addEdge('B', 'E', 7);

console.log("Dijkstra's Shortest Path Algorithm:");
graph.dijkstra('A');
