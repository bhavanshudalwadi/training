class Graph {
    constructor(vertices) {
        this.V = vertices;
        this.graph = new Array(vertices);
        for (let i = 0; i < vertices; ++i) {
            this.graph[i] = new Array(vertices);
            for (let j = 0; j < vertices; ++j) {
                this.graph[i][j] = 0;
            }
        }
    }

    addEdge(u, v, capacity) {
        this.graph[u][v] = capacity;
    }

    fordFulkerson(source, sink) {
        const parent = new Array(this.V);
        let maxFlow = 0;

        while (this.bfs(source, sink, parent)) {
            let pathFlow = Number.MAX_VALUE;
            for (let v = sink; v !== source; v = parent[v]) {
                const u = parent[v];
                pathFlow = Math.min(pathFlow, this.graph[u][v]);
            }

            for (let v = sink; v !== source; v = parent[v]) {
                const u = parent[v];
                this.graph[u][v] -= pathFlow;
                this.graph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    bfs(source, sink, parent) {
        const visited = new Array(this.V).fill(false);
        const queue = [];
        queue.push(source);
        visited[source] = true;
        parent[source] = -1;

        while (queue.length > 0) {
            const u = queue.shift();

            for (let v = 0; v < this.V; v++) {
                if (!visited[v] && this.graph[u][v] > 0) {
                    queue.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }
}

// Example usage:
const graph = new Graph(6);

graph.addEdge(0, 1, 16);
graph.addEdge(0, 2, 13);
graph.addEdge(1, 2, 10);
graph.addEdge(1, 3, 12);
graph.addEdge(2, 1, 4);
graph.addEdge(2, 4, 14);
graph.addEdge(3, 2, 9);
graph.addEdge(3, 5, 20);
graph.addEdge(4, 3, 7);
graph.addEdge(4, 5, 4);

console.log(graph.fordFulkerson(0, 5)); // Output: 23
