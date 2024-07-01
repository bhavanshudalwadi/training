public class P6 {
    public static void main(String[] args) {
        int a[] = {3, 5, 7, 8, 9}, sum = 0;
        for(int i=0; i<a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum/a.length);
    }
}
