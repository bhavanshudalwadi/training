public class P10 {
    public static void main(String[] args) {
        int m = 50, n = 35;
        while (n > 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        System.out.printf("GCD = %d \n", m);
    }
}
