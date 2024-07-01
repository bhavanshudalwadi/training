class Seventy {
    public static void intToRoman(int num) {  
        System.out.println("Integer: " + num); 
        
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
        
        StringBuilder roman = new StringBuilder();  
        
        for(int i = 0; i < values.length; i++) {  
            while(num >= values[i]) {               // 8 >= 5       3 >= 1      3 >= 1      3 >= 1    
                num -= values[i];                   // 3 = 8 - 5    2 = 3 - 1   2 = 3 - 1   2 = 3 - 1
                roman.append(romanLetters[i]);      // V            I           I           I
            }
        }
        System.out.println("Roman Numerals: " + roman.toString());
    }  
    public static void main(String args[]) {
        intToRoman(8);
    }
}  