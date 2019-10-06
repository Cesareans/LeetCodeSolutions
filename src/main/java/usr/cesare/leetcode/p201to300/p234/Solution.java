package usr.cesare.leetcode.p201to300.p234;


import usr.cesare.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Objects;

class Solution {
    // 另外一个解法：快慢指针找中间节点，然后调转其中一个链表，再依次比较节点值
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        while (list.size() > 1)if(!Objects.equals(list.pollFirst(), list.pollLast())) return false;
        return true;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(0);
        l.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(l));
    }
}
