package dePriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoubleEndedPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> minHeap; // Front (enqueue)
    private PriorityQueue<T> maxHeap; // Rear (dequeue)

    public DoubleEndedPriorityQueue() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    // Enqueue at the front of the queue
    public void enqueueFront(T element) {
        minHeap.offer(element);
    }

    // Enqueue at the rear of the queue
    public void enqueueRear(T element) {
        maxHeap.offer(element);
    }

    // Dequeue from the front of the queue
    public T dequeueFront() {
        if (minHeap.isEmpty()) {
            return null; // Queue is empty
        }
        T element = minHeap.poll();
        maxHeap.remove(element); // Remove from rear heap
        return element;
    }

    // Dequeue from the rear of the queue
    public T dequeueRear() {
        if (maxHeap.isEmpty()) {
            return null; // Queue is empty
        }
        T element = maxHeap.poll();
        minHeap.remove(element); // Remove from front heap
        return element;
    }

    // Peek at the front element without removing it
    public T peekFront() {
        return minHeap.peek();
    }

    // Peek at the rear element without removing it
    public T peekRear() {
        return maxHeap.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return minHeap.size();
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue<Integer> deque = new DoubleEndedPriorityQueue<>();

        // Enqueue at the front
        deque.enqueueFront(5);
        deque.enqueueFront(3);
        deque.enqueueFront(7);

        // Enqueue at the rear
        deque.enqueueRear(10);
        deque.enqueueRear(8);

        System.out.println("Front Peek: " + deque.peekFront()); // 3
        System.out.println("Rear Peek: " + deque.peekRear());   // 10

        // Dequeue from the front
        System.out.println("Dequeue Front: " + deque.dequeueFront()); // 3

        // Dequeue from the rear
        System.out.println("Dequeue Rear: " + deque.dequeueRear());   // 10

        System.out.println("Size: " + deque.size()); // 3
    }
}

