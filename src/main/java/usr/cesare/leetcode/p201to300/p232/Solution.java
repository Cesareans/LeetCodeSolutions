package usr.cesare.leetcode.p201to300.p232;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
}

class MyQueue {
    private Queue<Integer> popQueue;
    private Queue<Integer> pushQueue;

    /** Initialize your data structure here. */
    public MyQueue() {
        popQueue = new LinkedList<>();
        pushQueue = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!popQueue.isEmpty()) pushQueue.add(popQueue.poll());
        pushQueue.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!pushQueue.isEmpty()) popQueue.add(pushQueue.poll());
        return popQueue.poll();
    }

    /** Get the front element. */
    public int peek() {
        while (!pushQueue.isEmpty()) popQueue.add(pushQueue.poll());
        return popQueue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushQueue.isEmpty() && popQueue.isEmpty();
    }
}