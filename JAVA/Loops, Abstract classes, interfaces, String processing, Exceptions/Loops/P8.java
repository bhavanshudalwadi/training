public class P8 {
    public static void main(String[] args) {
        int a[] = {4, 5, 7, 8, 2};
        int b[] = new int[a.length];

        for(int i=a.length-1, j=0; i>=0; i--, j++) {
            b[j] = a[i];
            System.out.print(b[j]+", ");
        }
    }
}
