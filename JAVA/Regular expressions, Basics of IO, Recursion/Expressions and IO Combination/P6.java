import java.util.Scanner;

public class P6 {
    static String strRev(String str){
        char[] strArr = new char[str.length()];
        for(int i=0, j=strArr.length-1; i<strArr.length; i++, j--){
            strArr[i] = str.charAt(j);
        }
        return strArr.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();

        for(String string : str.split(" ")) {
            System.out.print(strRev(string) + " ");
        }
    }
}
