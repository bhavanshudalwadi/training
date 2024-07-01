public class P4 {
    public static void main(String[] args) {
        String str = "Bhavanshu";
        String str2 = "";

        for(int i=0; i<str.length(); i++) {
            if(!str2.contains(str.charAt(i)+"")) {
                str2 += str.charAt(i)+"";
            }
        }
        
        System.out.println(str2);
    }    
}
