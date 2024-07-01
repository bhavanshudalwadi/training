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

    isBipartite() {
        const color = new Map();
        const visited = new Set();

        for (const vertex of this.vertices.keys()) {
            if (!visited.has(vertex) && !this.dfsBipartite(vertex, color, visited, 1)) {
                return false;
            }
        }

        return true;
    }

    dfsBipartite(vertex, color, visited, currentColor) {
        visited.add(vertex);
        color.set(vertex, currentColor);

        for (const neighbor of this.vertices.get(vertex)) {
            if (!visited.has(neighbor)) {
                if (!this.dfsBipartite(neighbor, color, visited, -currentColor)) {
                    return false;
                }
            } else if (color.get(vertex) === color.get(neighbor)) {
                return false; // Not bipartite
            }
        }

        return true;
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
graph.addEdge('C', 'D');
graph.addEdge('D', 'A');

console.log("Is the graph bipartite?", graph.isBipartite());
