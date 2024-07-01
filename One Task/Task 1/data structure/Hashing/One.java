
class One {
    public static void main(String args[]) {
        String str = "bhavanshu";

        int[] hashTbl = new int[26];
        
        // Insertion
        for(int i=0; i<str.length(); i++) {
            System.out.print((str.charAt(i) - 'a') + " ");
            hashTbl[str.charAt(i) - 'a']++;
        }

        System.out.println();

        // Searching
        char ch = 'a';
        System.out.println("Count of "+ch+" is "+hashTbl[ch - 'a']);

        // Deletion
        char ch = 'b';
        hashTbl[ch - 'a'] = 0;
    }
}