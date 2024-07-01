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

    dfs(startVertex, visited = new Set()) {
        if (!this.vertices.has(startVertex)) {
            console.log(`Vertex ${startVertex} does not exist.`);
            return;
        }

        visited.add(startVertex);
        console.log(`Visited: ${startVertex}`);

        for (const neighbor of this.vertices.get(startVertex)) {
            if (!visited.has(neighbor)) {
                this.dfs(neighbor, visited);
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

console.log("DFS starting from vertex 'A':");
graph.dfs('A');
