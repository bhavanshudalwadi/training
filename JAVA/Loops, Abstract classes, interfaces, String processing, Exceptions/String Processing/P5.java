public class P5 {
    public static void main(String[] args) {
        String str = "hello this is hello game", word = "hello";
        String a[] = str.split(" ");
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            if (word.equals(a[i]))
                cnt++;
        }

        System.out.println(cnt);
    }
}
