import java.util.*; 

class Seven {
    public static LinkedList<Integer> dq = new LinkedList<Integer>();

    public static void addLeft(int n) {
        dq.addFirst(n);
    }

    public static void addRight(int n) {
        dq.addLast(n);
    }
    
    public static void removeLeft() {
        dq.removeFirst();
    }
    
    public static void removeRight() {
        dq.removeLast();
    }

    public static void main(String args[]) {
        // Double Ended Queue

        Seven.addLeft(5);
        Seven.addLeft(4);
        Seven.addRight(10);
        Seven.addRight(15);
        System.out.println(Seven.dq);
        Seven.removeLeft();
        Seven.removeRight();
        System.out.println(Seven.dq);
    }
}