
class One {
    public static void main(String args[]) {
        String str = "bhavanshu";

        int[] hashTbl = new int[26];
        
        for(int i=0; i<str.length(); i++) {
            System.out.print((str.charAt(i) - 'a') + " ");
            hashTbl[str.charAt(i) - 'a']++;
        }

        System.out.println();

        // char ch = 'a';
        // System.out.println("Count of "+ch+" is "+hashTbl[ch - 'a']);

        // First non repeting ch
        for(int i=0; i<26; i++) {
            if(hashTbl[i] == 1) {
                System.out.println((char)(i+'a'));
                break;
            }
        }
    }
}