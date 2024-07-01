class SeventyOne {
    public static void intToRoman(String roman) {  
        System.out.println("Roman: " + roman); 
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
        
        int num = 0;
        
        for(int i = 0; i < roman.length(); i++) {
            int index = 0;
            for(int j = 0; j < romanLetters.length; j++) {
                if(romanLetters[j].equals(String.valueOf(roman.charAt(i)))) {
                    index = j;
                }
            }
            int val = values[index];
            num += val;
        }
        System.out.println("Integer: " + num);
    }

    public static void main(String args[]) {
        intToRoman("X");
    }
}  