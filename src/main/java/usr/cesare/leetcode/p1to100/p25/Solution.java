package usr.cesare.leetcode.p1to100.p25;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode fakeHead = new ListNode(0), preHead = fakeHead;
        fakeHead.next = head;

        while (true) {
            int c = 0;
            ListNode tail = head;
            while (tail != null) {
                c++;
                if (c == k) {
                    break;
                }
                tail = tail.next;
            }
            if (c == k) {
                preHead.next = reverse(head, k);
                preHead = head;
                head = head.next;
            } else {
                break;
            }
        }
        return fakeHead.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode p = head, q = head.next, qhead = q;
        for (int i = 1; i < k; i++) {
            qhead = q.next;
            q.next = p;
            p = q;
            q = qhead;
        }
        head.next = qhead;
        return p;
    }
}

class Main{

    public static void main(String[] args) {
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 1));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 2));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 3));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 4));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 5));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{1,2,3,4,5}), 6));
        System.out.println(new Solution().reverseKGroup(ListNode.build(new int[]{}), 2));
        System.out.println(new Solution().reverseKGroup(null, 2));
    }
}