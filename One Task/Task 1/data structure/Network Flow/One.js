class BipartiteGraph {
    constructor(leftVertices, rightVertices) {
        this.leftVertices = leftVertices;
        this.rightVertices = rightVertices;
        this.adjacencyList = new Map();
    }

    addEdge(u, v) {
        if (!this.adjacencyList.has(u)) {
            this.adjacencyList.set(u, []);
        }
        this.adjacencyList.get(u).push(v);
    }

    hopcroftKarp() {
        const pairU = new Map();
        const pairV = new Map();
        const dist = new Map();

        let matching = 0;

        while (this.bfs(pairU, pairV, dist)) {
            for (const u of this.leftVertices) {
                if (!pairU.has(u) && this.dfs(u, pairU, pairV, dist)) {
                    matching++;
                }
            }
        }

        return matching;
    }

    bfs(pairU, pairV, dist) {
        const queue = [];
        for (const u of this.leftVertices) {
            if (!pairU.has(u)) {
                dist.set(u, 0);
                queue.push(u);
            } else {
                dist.set(u, Infinity);
            }
        }

        dist.set(null, Infinity);

        while (queue.length > 0) {
            const u = queue.shift();

            if (dist.get(u) < dist.get(null)) {
                for (const v of this.adjacencyList.get(u) || []) {
                    if (dist.get(pairV.get(v)) === Infinity) {
                        dist.set(pairV.get(v), dist.get(u) + 1);
                        queue.push(pairV.get(v));
                    }
                }
            }
        }

        return dist.get(null) !== Infinity;
    }

    dfs(u, pairU, pairV, dist) {
        if (u !== null) {
            for (const v of this.adjacencyList.get(u) || []) {
                if (dist.get(pairV.get(v)) === dist.get(u) + 1 && this.dfs(pairV.get(v), pairU, pairV, dist)) {
                    pairV.set(v, u);
                    pairU.set(u, v);
                    return true;
                }
            }

            dist.set(u, Infinity);
            return false;
        }

        return true;
    }
}

// Example usage:
const leftVertices = [1, 2, 3];
const rightVertices = ['A', 'B', 'C'];

const graph = new BipartiteGraph(leftVertices, rightVertices);

graph.addEdge(1, 'A');
graph.addEdge(1, 'B');
graph.addEdge(2, 'B');
graph.addEdge(2, 'C');
graph.addEdge(3, 'A');
graph.addEdge(3, 'C');

const maxMatching = graph.hopcroftKarp();
console.log(maxMatching); // Should print: 3
