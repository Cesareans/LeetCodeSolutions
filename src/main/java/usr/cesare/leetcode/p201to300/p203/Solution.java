package usr.cesare.leetcode.p201to300.p203;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode removeElements1(ListNode head, int val) {
        ListNode node = head, pre = head;
        while (node != null) {
            if(val == node.val){
                if(pre == node){
                    head = pre = (node = node.next);
                }else{
                    pre.next = (node = node.next);
                }
            }else {
                pre = node;
                node = node.next;
            }
        }
        return head;
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head, pre = head;
        while (node != null)  node = val == node.val? pre == node ? (head = pre = node.next) : (pre.next = node.next):(pre = node).next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[]{1, 2, 3, 4, 6, 1, 4, 2, 6});
        System.out.println(listNode = new Solution().removeElements(listNode, 6));
        System.out.println(listNode = new Solution().removeElements(listNode, 1));
        System.out.println(listNode = new Solution().removeElements(listNode, 2));
        System.out.println(listNode = new Solution().removeElements(listNode, 3));
        System.out.println(listNode = new Solution().removeElements(listNode, 4));
    }
}
