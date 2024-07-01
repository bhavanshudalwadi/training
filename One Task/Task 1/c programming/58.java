import java.util.*;

class FiftyEight {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(7);
        q.add(5);
        q.add(8);
        System.out.println(q);
        q.remove();
        System.out.println(q);
        System.out.println(q.peek());
    }
}