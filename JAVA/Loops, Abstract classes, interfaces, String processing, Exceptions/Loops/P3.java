public class P3 {
    public static void main(String[] args) {
        int n = 10, a = 0, b = 1, c = 0;
        System.out.print(a+", "+b);
        do {
            c = a + b;
            System.out.print(", "+c);
            a = b;
            b = c;
            n--;
        }while(n > 0);
    }
}
