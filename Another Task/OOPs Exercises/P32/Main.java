import java.util.concurrent.atomic.AtomicReference;

class LockFreeQueue<T> {
    private static class Node<T> {
        final T value;
        AtomicReference<Node<T>> next;

        Node(T value) {
            this.value = value;
            this.next = new AtomicReference<>(null);
        }
    }

    private final AtomicReference<Node<T>> head;
    private final AtomicReference<Node<T>> tail;

    public LockFreeQueue() {
        Node<T> dummyNode = new Node<>(null);
        this.head = new AtomicReference<>(dummyNode);
        this.tail = new AtomicReference<>(dummyNode);
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        while (true) {
            Node<T> currentTail = tail.get();
            Node<T> next = currentTail.next.get();

            if (currentTail == tail.get()) {
                if (next == null) {
                    // The tail is pointing to the last node
                    if (currentTail.next.compareAndSet(null, newNode)) {
                        // Enqueue successful, try to move the tail
                        tail.compareAndSet(currentTail, newNode);
                        return;
                    }
                } else {
                    // Another thread has moved the tail, try to update it
                    tail.compareAndSet(currentTail, next);
                }
            }
        }
    }

    public T dequeue() {
        while (true) {
            Node<T> currentHead = head.get();
            Node<T> currentTail = tail.get();
            Node<T> first = currentHead.next.get();

            if (currentHead == head.get()) {
                if (currentHead == currentTail) {
                    if (first == null) {
                        // Queue is empty
                        return null;
                    }
                    // Another thread has not updated the tail yet, try to move it
                    tail.compareAndSet(currentTail, first);
                } else {
                    T result = first.value;
                    // Try to move the head
                    if (head.compareAndSet(currentHead, first)) {
                        // Dequeue successful
                        return result;
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LockFreeQueue<Integer> lfQueue = new LockFreeQueue<>();

        // Enqueue operation in one thread
        lfQueue.enqueue(42);

        // Dequeue operation in another thread
        Integer result = lfQueue.dequeue();
        if (result != null) {
            // Successfully dequeued
            // Use 'result' as needed
            System.out.println("Successfully dequeued");
        } else {
            // Queue is empty
            System.out.println("Queue is empty");
        }
    }
}
