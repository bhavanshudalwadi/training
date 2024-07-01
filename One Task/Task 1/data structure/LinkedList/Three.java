
import java.util.*; 

class Three { 
	public static void main(String args[]) { 
		LinkedList<String> ll = new LinkedList<String>(); 

		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("E");

        LinkedList<String> revLL = new LinkedList<String>(); 

        for(int i=0, j=(ll.size()-1); i<ll.size(); i++, j--) {
            revLL.add(i, ll.get(j));
        }

		System.out.println(revLL);
	} 
}
