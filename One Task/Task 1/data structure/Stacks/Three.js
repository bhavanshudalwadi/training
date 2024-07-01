function infixToPostfix(infixExpression) {
    const precedence = {
        '+': 1,
        '-': 1,
        '*': 2,
        '/': 2,
        '^': 3
    };

    const isOperator = (char) => ['+', '-', '*', '/', '^'].includes(char);

    const result = [];
    const stack = [];

    for (let i = 0; i < infixExpression.length; i++) {
        let token = infixExpression[i];

        if (/[a-zA-Z0-9]/.test(token)) {
            // Operand, add to the result
            result.push(token);
        } else if (token === '(') {
            // Left parenthesis, push to the stack
            stack.push(token);
        } else if (token === ')') {
            // Right parenthesis, pop from the stack and add to the result until a matching '(' is found
            while (stack.length && stack[stack.length - 1] !== '(') {
                result.push(stack.pop());
            }
            stack.pop(); // Pop '('
        } else if (isOperator(token)) {
            // Operator, pop and add to the result while the stack has operators with higher or equal precedence
            while (stack.length && isOperator(stack[stack.length - 1]) && precedence[token] <= precedence[stack[stack.length - 1]]) {
                result.push(stack.pop());
            }
            stack.push(token);
        }
    }

    // Pop any remaining operators from the stack and add to the result
    while (stack.length) {
        result.push(stack.pop());
    }

    return result.join(' ');
}

// Example usage:

const infixExpression = "a + b * (c^d - e) / f";
const postfixExpression = infixToPostfix(infixExpression);

console.log("Infix Expression:", infixExpression);
console.log("Postfix Expression:", postfixExpression);
