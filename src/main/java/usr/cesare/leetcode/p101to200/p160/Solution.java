package usr.cesare.leetcode.p101to200.p160;

import usr.cesare.leetcode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0, lb = 0;
        ListNode t = headA;
        while (t != null) {
            la++;
            t = t.next;
        }
        t = headB;
        while (t != null) {
            lb++;
            t = t.next;
        }
        int d = Math.abs(la-lb);
        ListNode longer = la > lb ? headA : headB, shorter = la > lb ? headB : headA;
        for(int i = 0 ; i < d ; ++i){
            longer = longer.next;
        }
        while (longer != null && shorter != null){
            if(longer == shorter){
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode inter = new ListNode(8);
        inter.next = new ListNode(4);
        inter.next.next = new ListNode(5);
        ListNode ls = new ListNode(4);
        ls.next = new ListNode(1);
        //ls.next.next = inter;

        ListNode rs = new ListNode(5);
        rs.next = new ListNode(0);
        rs.next.next = new ListNode(1);
        //rs.next.next.next = inter;
        System.out.println(new Solution().getIntersectionNode(ls, rs));
    }
}
