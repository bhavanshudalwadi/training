import java.util.*;

class One {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(7);
        q.add(5);
        q.add(8);
        System.out.println(q);
        q.remove();
        // System.out.println(q.remove()+" Removed from Queue");
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);
    }
}