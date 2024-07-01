package dancingLink;

class Node {
    Node left, right, up, down;
    int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
