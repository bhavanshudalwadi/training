package dancingLink;

public class DancingLink {
    Node header;
    boolean[][] matrix;
    boolean[] solution;

    public DancingLink(boolean[][] matrix) {
        this.matrix = matrix;
        this.solution = new boolean[matrix[0].length];
        initialize();
    }

    private void initialize() {
        header = new Node(-1, -1);
        Node prev = header;

        // Create header nodes for each column
        for (int j = 0; j < matrix[0].length; j++) {
            Node newNode = new Node(-1, j);
            prev.right = newNode;
            newNode.left = prev;
            prev = newNode;
        }

        prev.right = header;
        header.left = prev;

        // Create nodes for each element in the matrix
        for (int i = 0; i < matrix.length; i++) {
            Node rowHeader = null;
            Node prevNode = null;

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    Node newNode = new Node(i, j);
                    if (rowHeader == null) {
                        rowHeader = newNode;
                    }

                    if (prevNode != null) {
                        prevNode.right = newNode;
                        newNode.left = prevNode;
                    }

                    Node columnHeader = findColumnNode(j);
                    Node lastNodeInColumn = columnHeader;
                    while (lastNodeInColumn.down != null) {
                        lastNodeInColumn = lastNodeInColumn.down;
                    }
                    lastNodeInColumn.down = newNode;
                    newNode.up = lastNodeInColumn;
                    columnHeader.up = newNode;
                    newNode.down = columnHeader;

                    prevNode = newNode;
                }
            }

            if (rowHeader != null) {
                prevNode.right = rowHeader;
                rowHeader.left = prevNode;
            }
        }
    }


    private Node findColumnNode(int col) {
        Node current = header.right;
        while (current.col != col) {
            current = current.right;
        }
        return current;
    }

    private void cover(Node columnHeader) {
        columnHeader.left.right = columnHeader.right;
        columnHeader.right.left = columnHeader.left;

        Node i = columnHeader.down;
        while (i != columnHeader) {
            Node j = i.right;
            while (j != i) {
                j.up.down = j.down;
                j.down.up = j.up;
                j = j.right;
            }
            i = i.down;
        }
    }

    private void uncover(Node columnHeader) {
        Node i = columnHeader.up;
        while (i != columnHeader) {
            Node j = i.left;
            while (j != i) {
                j.up.down = j;
                j.down.up = j;
                j = j.left;
            }
            i = i.up;
        }

        columnHeader.left.right = columnHeader;
        columnHeader.right.left = columnHeader;
    }

    private boolean search(int k) {
        if (header.right == header) {
            // Solution found
            printSolution();
            return true;
        }

        Node c = chooseColumn();
        cover(c);

        Node r = c.down;
        while (r != c) {
            solution[k] = true;

            Node j = r.right;
            while (j != r) {
                cover(j);
                j = j.right;
            }

            if (search(k + 1)) {
                return true;
            }

            j = r.left;
            while (j != r) {
                uncover(j);
                j = j.left;
            }

            solution[k] = false;
            r = r.down;
        }

        uncover(c);

        return false;
    }

    private Node chooseColumn() {
        Node columnHeader = header.right;
        Node minColumn = columnHeader;

        while (columnHeader != header) {
            if (columnHeader.right == columnHeader) {
                return columnHeader;
            }

            if (columnHeader.right.row < minColumn.right.row) {
                minColumn = columnHeader;
            }

            columnHeader = columnHeader.right;
        }

        return minColumn;
    }

    public void solve() {
        search(0);
    }

    private void printSolution() {
        for (int i = 0; i < solution.length; i++) {
            if (solution[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean[][] matrix = {
                {true, false, false, true, false, false, true},
                {true, false, false, true, true, false, false},
                {false, true, true, false, false, true, true},
                {false, true, true, false, true, true, false},
                {false, false, true, true, false, false, true},
                {false, false, true, true, true, true, false}
        };

        DancingLink dlx = new DancingLink(matrix);
        dlx.solve();
    }
}

