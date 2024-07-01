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
        this.adjList.get(w).push(v);
    }

    hasCycle() {
        const visited = new Array(this.vertices).fill(false);

        for (let i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                if (this.hasCycleUtil(i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    hasCycleUtil(vertex, parent, visited) {
        visited[vertex] = true;

        for (const neighbor of this.adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (this.hasCycleUtil(neighbor, vertex, visited)) {
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

const graph = new Graph(5);

graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 3);
graph.addEdge(3, 4);
graph.addEdge(4, 0);

if (graph.hasCycle()) {
    console.log("The graph contains a cycle.");
} else {
    console.log("The graph does not contain a cycle.");
}
