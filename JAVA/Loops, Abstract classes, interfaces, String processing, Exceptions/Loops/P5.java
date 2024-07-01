public class P5 {
    public static void main(String[] args) {
        int n = 9, flag = 0, i=2;
        while(i<n) {
            if(n%i == 0) {
                flag = 1;
            }
            i++;
        }
        System.out.println(flag==0?"Prime":"Not Prime");
    }
}
