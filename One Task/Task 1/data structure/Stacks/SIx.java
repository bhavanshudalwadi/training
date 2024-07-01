import java.util.*;

class Six {
    static void printStacks(Stack<String> A, Stack<String> B, Stack<String> C) {
        System.out.println("Updated Stack: ");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }

    public static void main(String args[]) {
        Stack<String> A = new Stack<String>();
        Stack<String> B = new Stack<String>();
        Stack<String> C = new Stack<String>();

        A.push("3");
        A.push("2");
        A.push("1");

        printStacks(A, B, C);

        C.push(A.pop());

        printStacks(A, B, C);

        B.push(A.pop());

        printStacks(A, B, C);

        B.push(C.pop());

        printStacks(A, B, C);

        C.push(A.pop());

        printStacks(A, B, C);

        A.push(B.pop());

        printStacks(A, B, C);

        C.push(B.pop());

        printStacks(A, B, C);

        C.push(A.pop());

        printStacks(A, B, C);
    }
}