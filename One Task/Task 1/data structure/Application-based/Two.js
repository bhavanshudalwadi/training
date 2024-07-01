class PriorityQueue {
    constructor() {
        this.heap = [];
    }

    // Insert an element into the priority queue
    insert(element) {
        this.heap.push(element);
        this.heapifyUp();
    }

    // Extract the minimum element from the priority queue
    extractMin() {
        if (this.isEmpty()) {
            return null;
        }

        const min = this.heap[0];
        const lastElement = this.heap.pop();

        if (this.heap.length > 0) {
            this.heap[0] = lastElement;
            this.heapifyDown();
        }

        return min;
    }

    // Check if the priority queue is empty
    isEmpty() {
        return this.heap.length === 0;
    }

    // Maintain the heap property by moving the last element up the heap
    heapifyUp() {
        let index = this.heap.length - 1;

        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);

            if (this.heap[parentIndex] <= this.heap[index]) {
                break; // Heap property is satisfied
            }

            // Swap the current element with its parent
            [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
            index = parentIndex;
        }
    }

    // Maintain the heap property by moving the first element down the heap
    heapifyDown() {
        let index = 0;

        while (true) {
            const leftChildIndex = 2 * index + 1;
            const rightChildIndex = 2 * index + 2;
            let smallest = index;

            if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[smallest]) {
                smallest = leftChildIndex;
            }

            if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[smallest]) {
                smallest = rightChildIndex;
            }

            if (smallest === index) {
                break; // Heap property is satisfied
            }

            // Swap the current element with the smallest child
            [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
            index = smallest;
        }
    }
}

// Example usage:

const priorityQueue = new PriorityQueue();

priorityQueue.insert(4);
priorityQueue.insert(2);
priorityQueue.insert(7);
priorityQueue.insert(1);

console.log("Priority Queue after insertion:", priorityQueue.heap);

console.log("Extracted Minimum Element:", priorityQueue.extractMin());
console.log("Priority Queue after extraction:", priorityQueue.heap);

priorityQueue.insert(3);
console.log("Priority Queue after insertion:", priorityQueue.heap);
