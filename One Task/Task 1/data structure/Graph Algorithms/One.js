class Graph {
    constructor(vertices) {
        this.vertices = vertices;
        this.adjList = new Map();

        for (let i = 0; i < vertices; i++) {
            this.adjList.set(i, []);
        }
    }

    addEdge(v, w) {
        this.adjList.get(v).push(w);
    }

    getTranspose() {
        const transposeGraph = new Graph(this.vertices);

        for (const [vertex, neighbors] of this.adjList) {
            for (const neighbor of neighbors) {
                transposeGraph.addEdge(neighbor, vertex);
            }
        }

        return transposeGraph;
    }

    fillOrder(vertex, visited, stack) {
        visited[vertex] = true;

        for (const neighbor of this.adjList.get(vertex)) {
            if (!visited[neighbor]) {
                this.fillOrder(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

    DFSUtil(vertex, visited, result) {
        visited[vertex] = true;
        result.push(vertex);

        for (const neighbor of this.adjList.get(vertex)) {
            if (!visited[neighbor]) {
                this.DFSUtil(neighbor, visited, result);
            }
        }
    }

    kosarajuSCC() {
        const stack = [];
        const visited = new Array(this.vertices).fill(false);

        // Fill order of vertices in stack
        for (let i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                this.fillOrder(i, visited, stack);
            }
        }

        // Create the transpose of the graph
        const transposeGraph = this.getTranspose();

        // Reset visited array
        visited.fill(false);

        const stronglyConnectedComponents = [];

        // Process vertices in order defined by stack
        while (stack.length > 0) {
            const vertex = stack.pop();

            if (!visited[vertex]) {
                const component = [];
                transposeGraph.DFSUtil(vertex, visited, component);
                stronglyConnectedComponents.push(component);
            }
        }

        return stronglyConnectedComponents;
    }
}

// Example usage:

const graph = new Graph(5);

graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 0);
graph.addEdge(1, 3);
graph.addEdge(3, 4);

const stronglyConnectedComponents = graph.kosarajuSCC();

console.log("Strongly Connected Components:");
console.log(stronglyConnectedComponents);
