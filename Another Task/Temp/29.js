function travelingSalesman(graph) {
    const n = graph.length;
    const visited = new Array(n).fill(false);
    let minCost = Number.MAX_VALUE;

    const tsp = (current, count, cost) => {
        if (count === n) {
            minCost = Math.min(minCost, cost + graph[current][0]);
            return;
        }

        for (let i = 0; i < n; i++) {
            if (!visited[i] && graph[current][i] !== 0) {
                visited[i] = true;
                tsp(i, count + 1, cost + graph[current][i]);
                visited[i] = false;
            }
        }
    };

    visited[0] = true;
    tsp(0, 1, 0);

    return minCost;
}

const graph = [
    [0, 10, 15, 20],
    [10, 0, 35, 25],
    [15, 35, 0, 30],
    [20, 25, 30, 0]
];

console.log(travelingSalesman(graph));
