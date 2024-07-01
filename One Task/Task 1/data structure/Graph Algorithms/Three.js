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

    topologicalSort() {
        const stack = [];
        const visited = new Array(this.vertices).fill(false);

        for (let i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                this.topologicalSortUtil(i, visited, stack);
            }
        }

        return stack.reverse(); // Reverse the stack to get the topological order
    }

    topologicalSortUtil(vertex, visited, stack) {
        visited[vertex] = true;

        for (const neighbor of this.adjList.get(vertex)) {
            if (!visited[neighbor]) {
                this.topologicalSortUtil(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }
}

// Example usage:

const graph = new Graph(6);

graph.addEdge(5, 2);
graph.addEdge(5, 0);
graph.addEdge(4, 0);
graph.addEdge(4, 1);
graph.addEdge(2, 3);
graph.addEdge(3, 1);

const topologicalOrder = graph.topologicalSort();

console.log("Topological Order:");
console.log(topologicalOrder);
