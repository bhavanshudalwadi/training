class Graph {
    constructor(vertices) {
        this.vertices = vertices;
        this.graph = new Map();

        for (let i = 0; i < vertices; i++) {
            this.graph.set(i, []);
        }
    }

    addEdge(u, v, capacity) {
        this.graph.get(u).push({ v, capacity, flow: 0 });
    }

    fordFulkerson(source, sink) {
        let parent = new Array(this.vertices);

        let maxFlow = 0;

        while (this.bfs(source, sink, parent)) {
            let pathFlow = Infinity;

            for (let v = sink; v !== source; v = parent[v]) {
                let u = parent[v];
                let edge = this.findEdge(u, v);

                pathFlow = Math.min(pathFlow, edge.capacity - edge.flow);
            }

            for (let v = sink; v !== source; v = parent[v]) {
                let u = parent[v];
                this.updateFlow(u, v, pathFlow);
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    bfs(source, sink, parent) {
        let visited = new Array(this.vertices).fill(false);
        let queue = [];

        queue.push(source);
        visited[source] = true;
        parent[source] = -1;

        while (queue.length > 0) {
            let u = queue.shift();

            for (let edge of this.graph.get(u)) {
                let v = edge.v;

                if (!visited[v] && edge.capacity > edge.flow) {
                    queue.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    findEdge(u, v) {
        for (let edge of this.graph.get(u)) {
            if (edge.v === v) {
                return edge;
            }
        }
        return null;
    }

    updateFlow(u, v, pathFlow) {
        let edge = this.findEdge(u, v);
        let reverseEdge = this.findEdge(v, u);

        edge.flow += pathFlow;
        reverseEdge.flow -= pathFlow;
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

const source = 0;
const sink = 5;

const minCut = graph.fordFulkerson(source, sink);
console.log(minCut); // Should print: 23
