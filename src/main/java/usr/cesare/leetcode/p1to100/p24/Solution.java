package usr.cesare.leetcode.p1to100.p24;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode resHead = head;
        if(resHead == null) return null;
        if(head.next != null){
            resHead = head.next;
            head.next = resHead.next;
            resHead.next = head;
        }
        ListNode pre = head, post = head.next;
        while (post != null && post.next != null){
            pre.next = post.next;
            post.next = pre.next.next;
            pre.next.next = post;
            pre = post;
            post = post.next;
        }
        return resHead;
    }
}
class Main{
    public static void main(String[] args) {
        System.out.println(new Solution().swapPairs(ListNode.build(new int[]{1,2,3,4,5})));
        System.out.println(new Solution().swapPairs(ListNode.build(new int[]{1,2,3,4})));
        System.out.println(new Solution().swapPairs(ListNode.build(new int[]{1,2})));
        System.out.println(new Solution().swapPairs(ListNode.build(new int[]{1})));
        System.out.println(new Solution().swapPairs(ListNode.build(new int[]{})));
    }
}
