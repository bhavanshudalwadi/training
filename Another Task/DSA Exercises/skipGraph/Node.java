package skipGraph;

class Node {
    int value;
    Node[] forward;

    public Node(int value, int level) {
        this.value = value;
        this.forward = new Node[level + 1];
    }
}
