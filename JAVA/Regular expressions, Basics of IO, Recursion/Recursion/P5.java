package Recursion;

public class P5 {
    public static String revStr(String str, int len) {
        if(len == 1) {
            return String.valueOf(str.charAt(0));
        }
        return str.charAt(len - 1) + revStr(str, --len);
    }
    public static void main(String[] args) {
        String str = "Bhavanshu";
        System.out.println(revStr(str, str.length()));
    }
}
