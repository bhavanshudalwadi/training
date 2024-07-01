package sbst;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        for(int i=0; i < 10; i++) {
            tree.insert(i);
        }

        tree.display();
        System.out.println(tree.height());
    }
}
