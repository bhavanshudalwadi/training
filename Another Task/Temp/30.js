function bellmanFord(graph, start) {
    const V = graph.length;
    const dist = new Array(V).fill(Number.MAX_VALUE);
    dist[start] = 0;

    for (let i = 0; i < V - 1; i++) {
        for (let j = 0; j < V; j++) {
            for (let k = 0; k < graph[j].length; k++) {
                if (graph[j][k] !== 0 && dist[j] !== Number.MAX_VALUE && dist[j] + graph[j][k] < dist[k]) {
                    dist[k] = dist[j] + graph[j][k];
                }
            }
        }
    }

    for (let j = 0; j < V; j++) {
        for (let k = 0; k < graph[j].length; k++) {
            if (graph[j][k] !== 0 && dist[j] !== Number.MAX_VALUE && dist[j] + graph[j][k] < dist[k]) {
                console.log("Graph contains negative weight cycle");
                return;
            }
        }
    }

    return dist;
}

const graph = [
    [0, 6, 0, 0, 0],
    [0, 0, 5, -4, 0],
    [0, 0, 0, 0, 2],
    [0, 1, 0, 0, 0],
    [0, 0, 0, -2, 0]
];

const startNode = 0;
console.log(bellmanFord(graph, startNode));