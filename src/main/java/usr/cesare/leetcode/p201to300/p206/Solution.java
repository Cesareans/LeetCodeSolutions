package usr.cesare.leetcode.p201to300.p206;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node, newHead = null;
        while ((node = head) != null){
            head = node.next;
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[]{1, 2, 3, 4, 6, 1, 4, 2, 6});
        System.out.println(new Solution().reverseList(listNode));
        ListNode listNode1 = ListNode.build(new int[]{1});
        System.out.println(new Solution().reverseList(listNode1));
        ListNode listNode2 = ListNode.build(new int[]{1, 2});
        System.out.println(new Solution().reverseList(listNode2));
        ListNode listNode3 = ListNode.build(new int[]{});
        System.out.println(new Solution().reverseList(listNode3));
    }
}
