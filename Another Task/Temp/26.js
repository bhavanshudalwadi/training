class Graph {
    constructor(vertices) {
        this.V = vertices;
        this.graph = new Map();
        for (let i = 0; i < vertices; ++i) {
            this.graph.set(i, []);
        }
    }

    addEdge(u, v) {
        this.graph.get(u).push(v);
    }

    tarjanSCC() {
        const stack = [];
        const lowLink = new Array(this.V).fill(-1);
        const ids = new Array(this.V).fill(-1);
        const onStack = new Array(this.V).fill(false);
        let id = 0;

        const strongConnect = (at) => {
            stack.push(at);
            onStack[at] = true;
            lowLink[at] = ids[at] = id++;

            this.graph.get(at).forEach(to => {
                if (ids[to] === -1) {
                    strongConnect(to);
                    lowLink[at] = Math.min(lowLink[at], lowLink[to]);
                } else if (onStack[to]) {
                    lowLink[at] = Math.min(lowLink[at], ids[to]);
                }
            });

            if (lowLink[at] === ids[at]) {
                let component = [];
                let node;
                do {
                    node = stack.pop();
                    onStack[node] = false;
                    component.push(node);
                } while (node !== at);
                console.log(component);
            }
        };

        for (let i = 0; i < this.V; ++i) {
            if (ids[i] === -1) {
                strongConnect(i);
            }
        }
    }
}

const graph = new Graph(5);

graph.addEdge(0, 1);
graph.addEdge(1, 2);
graph.addEdge(2, 0);
graph.addEdge(1, 3);
graph.addEdge(3, 4);

graph.tarjanSCC();
