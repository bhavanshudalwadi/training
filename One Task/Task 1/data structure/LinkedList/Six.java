import java.util.*; 

class Six {
    public static void main(String args[]) {
        LinkedList<String> ll = new LinkedList<String>(); 

		ll.add("A");
		ll.add("B");
		ll.add("B");
		ll.add("A");
		ll.add("B");
		ll.add("B");

        LinkedList<String> ans = new LinkedList<String>();

        for(int i=0; i<ll.size(); i++) {
            if(!ans.contains(ll.get(i))) {
                ans.add(ll.get(i));
            }
        }

        System.out.println(ans);
    }
} 