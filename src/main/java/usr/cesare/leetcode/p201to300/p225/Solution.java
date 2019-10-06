package usr.cesare.leetcode.p201to300.p225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }
}

class MyStack {
    private Queue<Integer>[] queues;
    private int cur, backup;
    private void swap(){
        int t = cur;
        cur = backup;
        backup = t;
    }
    /** Initialize your data structure here. */
    public MyStack() {
        queues = new Queue[2];
        cur = 0;
        backup = 1;
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queues[cur].add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queues[cur].size() > 1) queues[backup].add(queues[cur].poll());
        int i = queues[cur].poll();
        swap();
        return i;
    }

    /** Get the top element. */
    public int top() {
        while (queues[cur].size() > 1) {
            queues[backup].add(queues[cur].poll());
        }
        int i = queues[cur].poll();
        queues[backup].add(i);
        swap();
        return i;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queues[cur].isEmpty();
    }
}
