class Graph {
    constructor() {
        this.vertices = new Map();
    }

    addVertex(vertex) {
        if (!this.vertices.has(vertex)) {
            this.vertices.set(vertex, []);
        }
    }

    addEdge(source, destination) {
        if (this.vertices.has(source) && this.vertices.has(destination)) {
            this.vertices.get(source).push(destination);
        }
    }

    hasCycle() {
        const visited = new Set();
        const recursionStack = new Set();

        for (const vertex of this.vertices.keys()) {
            if (!visited.has(vertex)) {
                if (this.hasCycleDFS(vertex, visited, recursionStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    hasCycleDFS(vertex, visited, recursionStack) {
        visited.add(vertex);
        recursionStack.add(vertex);

        for (const neighbor of this.vertices.get(vertex)) {
            if (!visited.has(neighbor)) {
                if (this.hasCycleDFS(neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack.has(neighbor)) {
                return true; // Cycle detected
            }
        }

        recursionStack.delete(vertex);
        return false;
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
graph.addEdge('C', 'A');
graph.addEdge('D', 'E');

console.log("Does the directed graph have a cycle?", graph.hasCycle());
