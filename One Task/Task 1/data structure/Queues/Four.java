import java.util.*;

class Four {
    public static void main(String args[]) {
        int n = 7;
        String result[] = new String[n];

        Queue<String> q = new LinkedList<>();
        
        q.add("1");

        for(int i=0; i<n; i++) {
            result[i] = q.remove();

            String n1 = result[i] + "0";
            String n2 = result[i] + "1";

            q.add(n1);
            q.add(n2);
        } 

        for(String item: result) {
            System.out.print(item+" ");
        }
    }
}