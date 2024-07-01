public class P7 {
    public static int powOfNum(int n, int p) {
        if(p <= 1) {
            return n;
        }
        return n * powOfNum(n, --p);
    }
    public static void main(String[] args) {
        System.out.println(powOfNum(2, 3));
    }
}
