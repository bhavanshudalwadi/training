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

    hasCycle() {
        const visited = new Set();

        for (const vertex of this.vertices.keys()) {
            if (!visited.has(vertex) && this.hasCycleDFS(vertex, visited, null)) {
                return true;
            }
        }

        return false;
    }

    hasCycleDFS(vertex, visited, parent) {
        visited.add(vertex);

        for (const neighbor of this.vertices.get(vertex)) {
            if (!visited.has(neighbor)) {
                if (this.hasCycleDFS(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor !== parent) {
                return true; // Cycle detected
            }
        }

        return false;
    }
}

// Example usage:

const graph = new Graph();

graph.addVertex('A');
graph.addVertex('B');
graph.addVertex('C');
graph.addVertex('D');

graph.addEdge('A', 'B');
graph.addEdge('B', 'C');
graph.addEdge('C', 'A');
graph.addEdge('D', 'A');

console.log("Does the undirected graph have a cycle?", graph.hasCycle());
