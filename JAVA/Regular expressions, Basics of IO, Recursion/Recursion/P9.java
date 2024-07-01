package Recursion;

public class P9 {
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.printf("Shift Disk 1 from peg %c to peg %c\n", from, to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.printf("Shift Disk %d from peg %c to peg %c\n", n, from, to);
        towerOfHanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}

/*
 *      A   B   C
 *      1
 *      2
 *      3
 * 
 *      2
 *      3       1
 * 
 *      3   2   1
 * 
 *          1
 *      3   2
 * 
 *          1
 *          2   3
 *      
 *      1   2   3
 * 
 *              2
 *      1       3
 * 
 *              1
 *              2
 *              3
 */