class Graph {
    constructor() {
        this.vertices = new Map();
    }

    addVertex(vertex) {
        if (!this.vertices.has(vertex)) {
            this.vertices.set(vertex, []);
        } else {
            console.log(`Vertex ${vertex} already exists.`);
        }
    }

    addEdge(vertex1, vertex2) {
        if (this.vertices.has(vertex1) && this.vertices.has(vertex2)) {
            if (!this.vertices.get(vertex1).includes(vertex2)) {
                this.vertices.get(vertex1).push(vertex2);
                this.vertices.get(vertex2).push(vertex1);
            } else {
                console.log(`Edge between ${vertex1} and ${vertex2} already exists.`);
            }
        } else {
            console.log(`One or both of the vertices (${vertex1}, ${vertex2}) do not exist.`);
        }
    }

    removeVertex(vertex) {
        if (this.vertices.has(vertex)) {
            // Remove the vertex from the adjacency lists of all other vertices
            for (const adjVertex of this.vertices.get(vertex)) {
                this.vertices.get(adjVertex).filter(v => v !== vertex);
            }

            // Remove the vertex from the graph
            this.vertices.delete(vertex);
        } else {
            console.log(`Vertex ${vertex} does not exist.`);
        }
    }

    removeEdge(vertex1, vertex2) {
        if (this.vertices.has(vertex1) && this.vertices.has(vertex2)) {
            this.vertices.get(vertex1).filter(v => v !== vertex2);
            this.vertices.get(vertex2).filter(v => v !== vertex1);
        } else {
            console.log(`One or both of the vertices (${vertex1}, ${vertex2}) do not exist.`);
        }
    }

    printGraph() {
        for (const [vertex, edges] of this.vertices) {
            console.log(`${vertex} -> ${edges.join(', ')}`);
        }
    }
}

// Example usage:

const graph = new Graph();

graph.addVertex('A');
graph.addVertex('B');
graph.addVertex('C');
graph.addVertex('D');

graph.addEdge('A', 'B');
graph.addEdge('B', 'C');
graph.addEdge('C', 'D');
graph.addEdge('D', 'A');

console.log("Graph after adding edges:");
graph.printGraph();

graph.removeEdge('A', 'B');
graph.removeVertex('C');

console.log("\nGraph after removing edge ('A', 'B') and vertex 'C':");
graph.printGraph();
