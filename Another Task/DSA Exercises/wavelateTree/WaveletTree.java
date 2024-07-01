package wavelateTree;

import java.util.Arrays;

public class WaveletTree {
    private Node root;

    public WaveletTree(int[] sequence, int alphabetSize) {
        root = buildWaveletTree(sequence, 0, sequence.length - 1, alphabetSize);
    }

    private Node buildWaveletTree(int[] sequence, int left, int right, int alphabetSize) {
        if (left == right) {
            return new Node(sequence[left]);
        }

        int mid = (left + right) / 2;
        int[] leftSequence = new int[mid - left + 1];
        int[] rightSequence = new int[right - mid];

        for (int i = left; i <= right; i++) {
            if (i <= mid) {
                leftSequence[i - left] = sequence[i];
            } else {
                rightSequence[i - mid - 1] = sequence[i];
            }
        }

        Node leftChild = buildWaveletTree(leftSequence, left, mid, alphabetSize);
        Node rightChild = buildWaveletTree(rightSequence, mid + 1, right, alphabetSize);

        return new Node(leftChild, rightChild, alphabetSize);
    }

    // Rank query: Count occurrences of symbol 'c' in the range [1, pos]
    public int rank(int c, int pos) {
        return rank(root, c, pos + 1);
    }

    private int rank(Node node, int c, int pos) {
        if (node.isLeaf()) {
            return 0;
        }

        int mid = node.getLeftChild().getSize();
        if (c <= node.getAlphabetSize() && pos <= mid) {
            return rank(node.getLeftChild(), c, pos);
        } else {
            return mid + rank(node.getRightChild(), c, pos - mid);
        }
    }

    // Select query: Find the position of the k-th occurrence of symbol 'c'
    public int select(int c, int k) {
        return select(root, c, k);
    }

    private int select(Node node, int c, int k) {
        if (node.isLeaf()) {
            return -1; // Symbol not found
        }

        int mid = node.getLeftChild().getSize();
        if (c <= node.getAlphabetSize()) {
            if (k <= mid) {
                return select(node.getLeftChild(), c, k);
            } else {
                int pos = select(node.getRightChild(), c, k - mid);
                return (pos == -1) ? -1 : mid + pos;
            }
        } else {
            return select(node.getRightChild(), c, k);
        }
    }

    // Node class representing each node in the wavelet tree
    private static class Node {
        private Node leftChild;
        private Node rightChild;
        private int alphabetSize;
        private int[] bitmap;

        public Node(int symbol) {
            this.bitmap = new int[]{symbol};
            this.alphabetSize = 1;
        }

        public Node(Node leftChild, Node rightChild, int alphabetSize) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.alphabetSize = alphabetSize;
            this.bitmap = new int[alphabetSize];
            mergeBitmaps(leftChild.getBitmap(), rightChild.getBitmap());
        }

        public int[] getBitmap() {
            return bitmap;
        }

        public int getSize() {
            return bitmap.length;
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public int getAlphabetSize() {
            return alphabetSize;
        }

        private void mergeBitmaps(int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    bitmap[k++] = left[i++];
                } else {
                    bitmap[k++] = right[j++];
                }
            }

            while (i < left.length) {
                bitmap[k++] = left[i++];
            }

            while (j < right.length) {
                bitmap[k++] = right[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] sequence = {3, 1, 4, 4, 2, 3, 1, 2, 5};
        int alphabetSize = Arrays.stream(sequence).max().getAsInt();
        WaveletTree waveletTree = new WaveletTree(sequence, alphabetSize);

        System.out.println("Rank of 2 at position 6: " + waveletTree.rank(2, 6)); // 3
        System.out.println("Rank of 4 at position 4: " + waveletTree.rank(4, 4)); // 2

        System.out.println("Select 2nd occurrence of 4: " + waveletTree.select(4, 2)); // 7
        System.out.println("Select 1st occurrence of 1: " + waveletTree.select(1, 1)); // 2
    }
}

