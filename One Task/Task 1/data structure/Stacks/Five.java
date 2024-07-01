import java.util.*;

class Five {
    public static void main (String[] args) {
        Stack<Character> stack = new Stack<Character>();
 
        stack.push('B');
        stack.push('h');
        stack.push('a');
        stack.push('v');
        stack.push('a');
        stack.push('n');
        stack.push('s');
        stack.push('h');
        stack.push('u');

        Stack<Character> revStack = new Stack<Character>();

        int size = stack.size();

        for(int i=0; i<size; i++) {
            revStack.push(stack.pop());
        }

        System.out.println(revStack);
    }
}