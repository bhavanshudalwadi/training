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

    findConnectedComponents() {
        const visited = new Set();
        const components = [];

        for (const vertex of this.vertices.keys()) {
            if (!visited.has(vertex)) {
                const component = [];
                this.dfs(vertex, visited, component);
                components.push(component);
            }
        }

        return components;
    }

    dfs(startVertex, visited, component) {
        visited.add(startVertex);
        component.push(startVertex);

        for (const neighbor of this.vertices.get(startVertex)) {
            if (!visited.has(neighbor)) {
                this.dfs(neighbor, visited, component);
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
graph.addVertex('F');
graph.addVertex('G');

graph.addEdge('A', 'B');
graph.addEdge('B', 'C');
graph.addEdge('C', 'A');
graph.addEdge('D', 'E');
graph.addEdge('F', 'G');

console.log("Connected Components:");
const components = graph.findConnectedComponents();
components.forEach((component, index) => {
    console.log(`Component ${index + 1}: ${component.join(', ')}`);
});
