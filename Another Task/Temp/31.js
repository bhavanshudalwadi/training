function maxBipartiteMatching(graph, m, n) {
    const NIL = 0;
    const INF = Number.MAX_SAFE_INTEGER;

    const pairU = new Array(m + 1).fill(NIL);
    const pairV = new Array(n + 1).fill(NIL);
    const dist = new Array(m + 1).fill(0);

    function bfs() {
        const queue = [];
        for (let u = 1; u <= m; u++) {
            if (pairU[u] === NIL) {
                dist[u] = 0;
                queue.push(u);
            } else {
                dist[u] = INF;
            }
        }
        dist[NIL] = INF;

        while (queue.length > 0) {
            const u = queue.shift();
            if (dist[u] < dist[NIL]) {
                for (const v of graph[u]) {
                    if (dist[pairV[v]] === INF) {
                        dist[pairV[v]] = dist[u] + 1;
                        queue.push(pairV[v]);
                    }
                }
            }
        }

        return dist[NIL] !== INF;
    }

    function dfs(u) {
        if (u !== NIL) {
            for (const v of graph[u]) {
                if (dist[pairV[v]] === dist[u] + 1 && dfs(pairV[v])) {
                    pairV[v] = u;
                    pairU[u] = v;
                    return true;
                }
            }
            dist[u] = INF;
            return false;
        }
        return true;
    }

    let matching = 0;

    while (bfs()) {
        for (let u = 1; u <= m; u++) {
            if (pairU[u] === NIL && dfs(u)) {
                matching++;
            }
        }
    }

    return matching;
}

const graph = {
    1: [3],
    2: [3, 4],
    3: [1, 2],
    4: [2]
};

const m = 4;
const n = 4;

console.log(maxBipartiteMatching(graph, m, n));
