import java.util.LinkedList;

class Buffer {
    private LinkedList<Integer> buffer;
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    public void produce(int item) throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == capacity) {
                wait();
            }

            System.out.println("Produced: " + item);
            buffer.add(item);

            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == 0) {
                wait();
            }

            int item = buffer.removeFirst();
            System.out.println("Consumed: " + item);
            notify();
        }
    }
}

class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                buffer.produce(i);
                sleep(1000); // Simulating some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                buffer.consume();
                sleep(1500); // Simulating some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Eighty {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(2);

        // Creating producer and consumer threads
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Starting the threads
        producer.start();
        consumer.start();
    }
}
