import java.util.*; 

class Five {
   public static void main(String args[]) {
        LinkedList<String> ll1 = new LinkedList<String>(); 

		ll1.add("A");
		ll1.add("B");
		ll1.add("B");
		ll1.add("C");
		ll1.add("D");
		ll1.add("E");

        LinkedList<String> ll2 = new LinkedList<String>(); 

		ll2.add("H");
		ll2.add("A");
		ll2.add("J");
		ll2.add("D");
		ll2.add("B");

        LinkedList<String> ans = new LinkedList<String>(); 

        for(int i=0; i<ll1.size(); i++) {
            for(int j=0; j<ll2.size(); j++) {
                if(ll1.get(i).equals(ll2.get(j)) && !ans.contains(ll1.get(i))) {
                    ans.add(ll1.get(i));
                }
            }
        }
       

        System.out.println(ans);
   } 
}