public class P6 {
    public static void main(String[] args) {
        String str = "hello this isjdfgjh hello gamejk";
        String a[] = str.split(" ");
        int max = a[0].length();
        String maxWord = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > max) {
                maxWord = a[i];
                max = a[i].length();
            }
        }

        System.out.println(maxWord);
    }
}
