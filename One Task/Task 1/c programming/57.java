import java.util.*;

class FiftySeven {
    public static void main (String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Element Poped: "+stack.pop());
        System.out.println("Top Element: "+stack.peek());
    }
}