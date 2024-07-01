package Recursion;

public class P6 {
    public static boolean checkPalindrom(String str, int left, int right) {
        if(left + 1 == right) {
            return true;
        }
        return str.charAt(left) == str.charAt(right) && checkPalindrom(str, ++left, --right);
    }

    public static void main(String[] args) {
        String str = "maam";
        System.out.println(checkPalindrom(str, 0, str.length() - 1));
    }
}
