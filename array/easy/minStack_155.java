import java.util.Stack;

// two stack approach
public class minStack_155 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // pair stack
    class PairMinStack {
        class Pair {
            int value;
            int min;

            Pair(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }

        Stack<Pair> stack = new Stack<>();

        public void push(int value) {
            if (stack.isEmpty()) {
                stack.push(new Pair(value, value));
            } else {
                int currentMin = stack.peek().min;
                int newMin = Math.min(value, currentMin);
                stack.push(new Pair(value, newMin));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }

    // encoding solution
    class encodingMinStack {
        Stack<Long> stack = new Stack<>();
        long min;

        public void push(int value) {
            if (stack.isEmpty()) {
                stack.push((long) value);
                min = value;
            } else if (value >= min) {
                stack.push((long) value);
            } else {
                long encoded = 2L * value - min;
                stack.push(encoded);
                min = value;
            }
        }

        public void pop() {
            long top = stack.pop();
            if (top < min) {
                min = 2 * min - top;
            }
        }

        public int top() {
            long top = stack.peek();
            if (top < min) {
                return (int) min;
            }
            return (int) top;
        }

        public int getMIn() {
            return (int) min;
        }
    }
}
