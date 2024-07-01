class Queue {
    constructor() {
        this.items = [];
    }

    enqueue(item) {
        this.items.push(item);
    }

    dequeue() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        return this.items.shift();
    }

    front() {
        if (this.isEmpty()) {
            return "Queue is empty";
        }
        return this.items[0];
    }

    isEmpty() {
        return this.items.length === 0;
    }

    size() {
        return this.items.length;
    }

    reverseFirstK(k) {
        if (k <= 0 || k > this.size()) {
            return "Invalid value of k";
        }

        const stack = [];

        // Dequeue the first k elements and push them onto the stack
        for (let i = 0; i < k; i++) {
            stack.push(this.dequeue());
        }

        // Enqueue elements from the stack back into the queue in reverse order
        while (stack.length > 0) {
            this.enqueue(stack.pop());
        }
    }

    printQueue() {
        console.log(this.items.join(' '));
    }
}

// Example usage:

const queue = new Queue();

// Enqueue elements to the queue
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);
queue.enqueue(5);

console.log("Original Queue:");
queue.printQueue();

const k = 3;
queue.reverseFirstK(k);

console.log(`Queue after reversing the first ${k} elements:`);
queue.printQueue();
