// Implementation of LinkedList 

import java.util.*; 

class FiftySix { 

	public static void main(String args[]) { 
		LinkedList<String> ll = new LinkedList<String>(); 

		ll.add("A"); 
		ll.add("B"); 
		ll.add("C"); 
		ll.add("D"); 
		ll.addLast("E"); 
		ll.addFirst("F"); 
		ll.add(2, "G"); 

		System.out.println(ll); 

		ll.remove("B"); 
		ll.remove(3); 
		ll.removeFirst(); 
		ll.removeLast(); 

		for(int i = 0; i < ll.size(); i++) { 
            System.out.print(ll.get(i) + " "); 
        } 
	} 
}
