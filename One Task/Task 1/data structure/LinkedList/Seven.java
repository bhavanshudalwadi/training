import java.util.*;

class Seven {
    public static void main(String args[]) {
        LinkedList<Integer> ll = new LinkedList<Integer>(); 

		ll.add(12);
		ll.add(67);
		ll.add(36);
		ll.add(90);
		ll.add(19);

        int sum = 0;

        for(int i=0; i<ll.size(); i++) {
            sum += ll.get(i);
        }

        System.out.println("Sum of LL: "+sum);
    }
}