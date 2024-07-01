package hopcroftKarp;

import java.util.*;

public class HopcroftKarp {

    
    static class BipartiteGraph {
        int leftVertices;
        int rightVertices;
        Map<Integer, Set<Integer>> adjacencyList;

        BipartiteGraph(int leftVertices, int rightVertices) {
            this.leftVertices = leftVertices;
            this.rightVertices = rightVertices;
            this.adjacencyList = new HashMap<>();

            
            for (int i = 1; i <= leftVertices; i++) {
                adjacencyList.put(i, new HashSet<>());
            }
        }

        void addEdge(int leftVertex, int rightVertex) {
            adjacencyList.get(leftVertex).add(rightVertex);
        }
    }

    
    static class HopcroftKarpAlgorithm {
        BipartiteGraph graph;
        int[] matching;
        int[] distance;

        HopcroftKarpAlgorithm(BipartiteGraph graph) {
            this.graph = graph;
            this.matching = new int[graph.rightVertices + 1];
            this.distance = new int[graph.leftVertices + 1];
        }

        
        boolean bfs() {
            Queue<Integer> queue = new LinkedList<>();

            
            for (int leftVertex = 1; leftVertex <= graph.leftVertices; leftVertex++) {
                if (matching[leftVertex] == 0) {
                    distance[leftVertex] = 0;
                    queue.add(leftVertex);
                } else {
                    distance[leftVertex] = Integer.MAX_VALUE;
                }
            }

            distance[0] = Integer.MAX_VALUE;

            
            while (!queue.isEmpty()) {
                int leftVertex = queue.poll();

                if (distance[leftVertex] < distance[0]) {
                    for (int rightVertex : graph.adjacencyList.get(leftVertex)) {
                        if (distance[matching[rightVertex]] == Integer.MAX_VALUE) {
                            distance[matching[rightVertex]] = distance[leftVertex] + 1;
                            queue.add(matching[rightVertex]);
                        }
                    }
                }
            }

            return distance[0] != Integer.MAX_VALUE;
        }

        
        boolean dfs(int leftVertex) {
            if (leftVertex != 0) {
                for (int rightVertex : graph.adjacencyList.get(leftVertex)) {
                    if (distance[matching[rightVertex]] == distance[leftVertex] + 1 && dfs(matching[rightVertex])) {
                        matching[rightVertex] = leftVertex;
                        matching[leftVertex] = rightVertex;
                        return true;
                    }
                }
                distance[leftVertex] = Integer.MAX_VALUE;
                return false;
            }
            return true;
        }

        
        int findMaximumMatching() {
            int matchingSize = 0;

            while (bfs()) {
                for (int leftVertex = 1; leftVertex <= graph.leftVertices; leftVertex++) {
                    if (matching[leftVertex] == 0 && dfs(leftVertex)) {
                        matchingSize++;
                    }
                }
            }

            return matchingSize;
        }
    }

    public static void main(String[] args) {
        
        int leftVertices = 4;
        int rightVertices = 4;

        BipartiteGraph graph = new BipartiteGraph(leftVertices, rightVertices);

        
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);

        HopcroftKarpAlgorithm hopcroftKarp = new HopcroftKarpAlgorithm(graph);
        int maximumMatchingSize = hopcroftKarp.findMaximumMatching();

        System.out.println("Maximum Cardinality Matching Size: " + maximumMatchingSize);
    }
}
