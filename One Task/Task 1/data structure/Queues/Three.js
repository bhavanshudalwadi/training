class CircularQueue {
    constructor(capacity) {
        this.capacity = capacity;
        this.queue = new Array(capacity);
        this.front = this.rear = -1;
    }

    enqueue(item) {
        if ((this.rear + 1) % this.capacity === this.front) {
            console.log("Queue is full. Cannot enqueue.");
            return;
        }

        if (this.isEmpty()) {
            this.front = this.rear = 0;
        } else {
            this.rear = (this.rear + 1) % this.capacity;
        }

        this.queue[this.rear] = item;
        console.log(`${item} enqueued to the queue.`);
    }

    dequeue() {
        if (this.isEmpty()) {
            console.log("Queue is empty. Cannot dequeue.");
            return;
        }

        const item = this.queue[this.front];

        if (this.front === this.rear) {
            this.front = this.rear = -1;
        } else {
            this.front = (this.front + 1) % this.capacity;
        }

        console.log(`${item} dequeued from the queue.`);
        return item;
    }

    front() {
        if (this.isEmpty()) {
            console.log("Queue is empty.");
            return;
        }
        return this.queue[this.front];
    }

    isEmpty() {
        return this.front === -1;
    }

    isFull() {
        return (this.rear + 1) % this.capacity === this.front;
    }

    printQueue() {
        if (this.isEmpty()) {
            console.log("Queue is empty.");
            return;
        }

        let current = this.front;
        while (current !== this.rear) {
            console.log(this.queue[current]);
            current = (current + 1) % this.capacity;
        }
        console.log(this.queue[current]);
    }
}

// Example usage:

const circularQueue = new CircularQueue(5);

circularQueue.enqueue(1);
circularQueue.enqueue(2);
circularQueue.enqueue(3);
circularQueue.enqueue(4);
circularQueue.enqueue(5);

circularQueue.printQueue();

console.log("Front of the queue:", circularQueue.front());

circularQueue.dequeue();
circularQueue.dequeue();

console.log("After dequeue operations:");

circularQueue.printQueue();

circularQueue.enqueue(6);
circularQueue.enqueue(7);

console.log("After enqueue operations:");

circularQueue.printQueue();
