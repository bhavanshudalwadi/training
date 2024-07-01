public class FibonacciGenerator {

    public static void main(String[] args) {
        // Generate Fibonacci sequence up to the 10th element
        FibonacciSequence<10> fibonacciSequence = new FibonacciSequence<>();
        System.out.println(fibonacciSequence.toString());
    }

    static class FibonacciSequence<N extends Number> {
        private final String sequence;

        public FibonacciSequence() {
            this.sequence = generateSequence();
        }

        private String generateSequence() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < N.intValue(); i++) {
                result.append(fibonacci(i)).append(" ");
            }
            return result.toString();
        }

        private int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        @Override
        public String toString() {
            return sequence;
        }
    }
}
