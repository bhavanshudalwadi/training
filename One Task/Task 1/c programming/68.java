import java.util.Stack;

class SixtyEight {
	static int evaluatePostfix(String exp) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (Character.isDigit(c)){
				stack.push(c - '0');
            }else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
				}
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "231*+9-";
	
		System.out.println("Postfix Evaluation: " + evaluatePostfix(exp));
	}
}


/*
	231* // 3 * 1
	23
	23+ // 3 + 2
	5
	59- // 5 - 9
	-4
*/