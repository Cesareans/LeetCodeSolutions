package usr.cesare.leetcode.p101to200.p155;

import java.util.LinkedList;

class MinStack {
    private LinkedList<Integer> minStack;
    private LinkedList<Integer> stack;

    public MinStack() {
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        Integer i = minStack.peekFirst();
        minStack.push(i == null ? x : Math.min(i, x));
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println(minStack.top()); // Returns 0.
        System.out.println(minStack.getMin());  // Returns -2.
    }
}
