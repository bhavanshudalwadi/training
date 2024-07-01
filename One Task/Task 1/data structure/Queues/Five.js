class MinStack {
    constructor() {
        this.stack = [];
        this.minStack = [];
    }

    push(val) {
        this.stack.push(val);

        if (this.minStack.length === 0 || val <= this.minStack[this.minStack.length - 1]) {
            this.minStack.push(val);
        }
    }

    pop() {
        if (this.stack.length === 0) {
            console.log("Stack is empty. Cannot pop.");
            return;
        }

        const popped = this.stack.pop();

        if (popped === this.minStack[this.minStack.length - 1]) {
            this.minStack.pop();
        }

        return popped;
    }

    top() {
        if (this.stack.length === 0) {
            console.log("Stack is empty.");
            return;
        }

        return this.stack[this.stack.length - 1];
    }

    getMin() {
        if (this.minStack.length === 0) {
            console.log("Stack is empty.");
            return;
        }

        return this.minStack[this.minStack.length - 1];
    }
}

// Example usage:

const minStack = new MinStack();

minStack.push(3);
minStack.push(5);
minStack.push(2);
minStack.push(8);

console.log("Current Stack:", minStack.stack);
console.log("Minimum Element:", minStack.getMin());

minStack.pop();

console.log("After Pop:");
console.log("Current Stack:", minStack.stack);
console.log("Minimum Element:", minStack.getMin());
