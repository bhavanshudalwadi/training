package skipGraph;

import java.util.Random;

public class SkipGraph {
    private static final int MAX_LEVEL = 16;
    private int level;
    private Node head;

    public SkipGraph() {
        this.level = 0;
        this.head = new Node(Integer.MIN_VALUE, MAX_LEVEL);
    }

    private int randomLevel() {
        Random random = new Random();
        int level = 0;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }
    public void insert(int value) {
        int newLevel = randomLevel();
        Node newNode = new Node(value, newLevel);

        Node current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }

            if (i <= newLevel) {
                newNode.forward[i] = current.forward[i];
                current.forward[i] = newNode;
            }
        }

        if (newLevel > level) {
            level = newLevel;
        }
    }
    public boolean search(int value) {
        Node current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }

        return current.forward[0] != null && current.forward[0].value == value;
    }

    public void print() {
        for (int i = level; i >= 0; i--) {
            Node current = head;
            System.out.print("Level " + i + ": ");
            while (current.forward[i] != null) {
                System.out.print(current.forward[i].value + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SkipGraph skipGraph = new SkipGraph();
        skipGraph.insert(3);
        skipGraph.insert(6);
        skipGraph.insert(7);
        skipGraph.insert(9);
        skipGraph.insert(12);
        skipGraph.insert(19);
        skipGraph.insert(17);
        skipGraph.insert(26);
        skipGraph.insert(21);
        skipGraph.insert(25);

        skipGraph.print();

        System.out.println("Search for 12: " + skipGraph.search(12));
        System.out.println("Search for 20: " + skipGraph.search(20));
    }
}

