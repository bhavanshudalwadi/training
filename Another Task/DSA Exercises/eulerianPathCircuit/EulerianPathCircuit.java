package eulerianPathCircuit;

import java.util.*;

public class EulerianPathCircuit {
    private int vertices;
    private List<List<Integer>> graph;

    public EulerianPathCircuit(int vertices) {
        this.vertices = vertices;
        this.graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    
    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    
    public boolean hasEulerianPathCircuit() {
        int oddDegreeCount = 0;

        for (int i = 0; i < vertices; i++) {
            if (graph.get(i).size() % 2 != 0) {
                oddDegreeCount++;
            }
        }

        if (oddDegreeCount == 0) {
            
            return true;
        } else if (oddDegreeCount == 2) {
            
            return true;
        } else {
            
            return false;
        }
    }

    
    public List<Integer> findEulerianPathCircuit() {
        if (!hasEulerianPathCircuit()) {
            return null; 
        }

        int startVertex = 0; 

        for (int i = 0; i < vertices; i++) {
            if (graph.get(i).size() % 2 != 0) {
                startVertex = i; 
                break;
            }
        }

        
        Stack<Integer> stack = new Stack<>();
        List<Integer> circuit = new ArrayList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (graph.get(u).size() > 0) {
                int v = graph.get(u).remove(0);
                stack.push(v);
            } else {
                circuit.add(stack.pop());
            }
        }

        Collections.reverse(circuit);
        return circuit;
    }

    public static void main(String[] args) {
        EulerianPathCircuit graph = new EulerianPathCircuit(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        if (graph.hasEulerianPathCircuit()) {
            List<Integer> eulerianPathCircuit = graph.findEulerianPathCircuit();
            System.out.println("Eulerian Path or Circuit: " + eulerianPathCircuit);
        } else {
            System.out.println("No Eulerian Path or Circuit exists.");
        }
    }
}
