public class P1 {
    public static void main(String[] args) {
        String str = "Bhavanshu";
        str = str.toLowerCase();
        int v = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                v++;
            }
        }
        System.out.println(v);
    }
}
