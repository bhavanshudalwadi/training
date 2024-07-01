class Nine{
    public static void main(String args[]) {
        int n = 200, rem = 0;

        String rev = "";

        while(n > 0) {                  
            rem = n % 10;               //3;      2;      1;
            rev += String.valueOf(((rev != ""?Integer.parseInt(rev):0) * 10) + rem);     //3;      32;     321;
            n = n / 10;                 //12;     1;      0;
        }

        System.out.println(rev);
    }
}