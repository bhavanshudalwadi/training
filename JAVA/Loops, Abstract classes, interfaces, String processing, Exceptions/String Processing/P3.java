public class P3 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("maam");
        if(str == str.reverse()) {
            System.out.println(str+" is palindrom string");
        }
    }
}
