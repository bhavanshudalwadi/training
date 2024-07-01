
import java.util.*; 

class Two { 
	public static void main(String args[]) { 
		LinkedList<String> ll = new LinkedList<String>(); 

		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("E");

        System.out.print("Middle Element of "+ll+" is "+ll.get(ll.size()/2));
	} 
}
