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

    findArticulationPoints() {
        let time = 0; // Time for DFS traversal
        const articulationPoints = [];
        const visited = new Array(this.vertices).fill(false);
        const disc = new Array(this.vertices).fill(0);
        const low = new Array(this.vertices).fill(0);
        const parent = new Array(this.vertices).fill(-1);

        const dfs = (vertex) => {
            let children = 0;
            visited[vertex] = true;
            disc[vertex] = low[vertex] = ++time;

            for (const neighbor of this.adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    children++;
                    parent[neighbor] = vertex;
                    dfs(neighbor);

                    low[vertex] = Math.min(low[vertex], low[neighbor]);

                    if (low[neighbor] >= disc[vertex] && parent[vertex] !== -1) {
                        articulationPoints.push(vertex);
                    }

                    if (parent[vertex] === -1 && children > 1) {
                        articulationPoints.push(vertex);
                    }
                } else if (neighbor !== parent[vertex]) {
                    low[vertex] = Math.min(low[vertex], disc[neighbor]);
                }
            }
        };

        for (let i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        return articulationPoints;
    }
}

// Example usage:

const graph = new Graph(7);

graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 0);
graph.addEdge(1, 3);
graph.addEdge(1, 4);
graph.addEdge(1, 6);
graph.addEdge(3, 5);
graph.addEdge(4, 5);

const articulationPoints = graph.findArticulationPoints();

console.log("Articulation Points:");
console.log(articulationPoints);
