package usr.cesare.leetcode.p1to100.p19;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        if(node == null) return null;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        if(node == null){
            return head.next;
        }
        ListNode preNode = head;
        while (node.next != null){
            node = node.next;
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }

}
class Main{

    public static void main(String[] args) {
        ListNode head = ListNode.build(new int[]{1,2,3,4,5});
        System.out.println(new Solution().removeNthFromEnd(head, 2));
        System.out.println(new Solution().removeNthFromEnd(head, 1));
        System.out.println(new Solution().removeNthFromEnd(head, 2));
        System.out.println(new Solution().removeNthFromEnd(head, 1));
        System.out.println(new Solution().removeNthFromEnd(head, 1));
    }
}