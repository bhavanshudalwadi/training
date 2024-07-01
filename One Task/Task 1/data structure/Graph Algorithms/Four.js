class Graph {
    constructor(vertices) {
        this.vertices = vertices;
        this.adjMatrix = Array.from({ length: vertices }, () => Array(vertices).fill(0));
    }

    addEdge(source, destination, capacity) {
        this.adjMatrix[source][destination] = capacity;
    }

    fordFulkerson(source, sink) {
        const residualGraph = this.adjMatrix.map(row => row.slice()); // Create a copy of the adjacency matrix

        let maxFlow = 0;

        while (true) {
            const { path, minCapacity } = this.findAugmentingPath(residualGraph, source, sink);

            if (!path) {
                break; // No augmenting path found
            }

            for (let i = 0; i < path.length - 1; i++) {
                const u = path[i];
                const v = path[i + 1];

                residualGraph[u][v] -= minCapacity;
                residualGraph[v][u] += minCapacity;
            }

            maxFlow += minCapacity;
        }

        return maxFlow;
    }

    findAugmentingPath(residualGraph, source, sink) {
        const parent = Array(this.vertices).fill(-1);
        const visited = Array(this.vertices).fill(false);
        const queue = [source];

        while (queue.length > 0) {
            const u = queue.shift();
            visited[u] = true;

            for (let v = 0; v < this.vertices; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    parent[v] = u;
                    queue.push(v);

                    if (v === sink) {
                        // Found an augmenting path
                        let minCapacity = Number.MAX_SAFE_INTEGER;
                        let current = sink;

                        while (parent[current] !== -1) {
                            const u = parent[current];
                            minCapacity = Math.min(minCapacity, residualGraph[u][current]);
                            current = u;
                        }

                        return { path: this.reconstructPath(parent, source, sink), minCapacity };
                    }
                }
            }
        }

        return { path: null, minCapacity: 0 }; // No augmenting path found
    }

    reconstructPath(parent, source, sink) {
        const path = [];
        let current = sink;

        while (current !== source) {
            path.unshift(current);
            current = parent[current];
        }

        path.unshift(source);
        return path;
    }
}

// Example usage:

const graph = new Graph(6);

graph.addEdge(0, 1, 10);
graph.addEdge(0, 2, 10);
graph.addEdge(1, 2, 2);
graph.addEdge(1, 3, 4);
graph.addEdge(1, 4, 8);
graph.addEdge(2, 4, 9);
graph.addEdge(3, 5, 10);
graph.addEdge(4, 3, 6);
graph.addEdge(4, 5, 10);

const maxFlow = graph.fordFulkerson(0, 5);
console.log("Maximum Flow:", maxFlow);
