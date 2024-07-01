package layeredRangeTree;

class Node {
    Point point;
    Node left, right;

    public Node(Point point) {
        this.point = point;
        this.left = this.right = null;
    }
}
