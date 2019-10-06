package usr.cesare.leetcode.p201to300.p237;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while(node.next != null){
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}