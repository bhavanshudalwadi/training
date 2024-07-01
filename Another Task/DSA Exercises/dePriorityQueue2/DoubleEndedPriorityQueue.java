package dePriorityQueue2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoubleEndedPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> minHeap;
    private PriorityQueue<T> maxHeap;

    public DoubleEndedPriorityQueue() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    public void enqueueFront(T element) {
        minHeap.offer(element);
    }

    public void enqueueRear(T element) {
        maxHeap.offer(element);
    }

    public T dequeueFront() {
        if (minHeap.isEmpty()) {
            return null;
        }
        T element = minHeap.poll();
        maxHeap.remove(element);
        return element;
    }
    public T dequeueRear() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        T element = maxHeap.poll();
        minHeap.remove(element);
        return element;
    }
    public T peekFront() {
        return minHeap.peek();
    }

    public T peekRear() {
        return maxHeap.peek();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    public int size() {
        return minHeap.size();
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue<Integer> deque = new DoubleEndedPriorityQueue<>();

        deque.enqueueFront(5);
        deque.enqueueFront(3);
        deque.enqueueFront(7);

        deque.enqueueRear(10);
        deque.enqueueRear(8);

        System.out.println("Front Peek: " + deque.peekFront());
        System.out.println("Rear Peek: " + deque.peekRear());

        System.out.println("Dequeue Front: " + deque.dequeueFront());

        System.out.println("Dequeue Rear: " + deque.dequeueRear());

        System.out.println("Size: " + deque.size());
    }
}

