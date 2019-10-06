package usr.cesare.leetcode.p1to100.p21;


import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    void print(){
        ListNode l = this;
        System.out.print("[" + l.val);
        while (l.next != null){
            l = l.next;
            System.out.print(", " + l.val);
        }
        System.out.println("]");
    }
    void add(int v){
        ListNode n = this;
        while (n.next != null) n = n.next;
        n.next = new ListNode(v);
    }
    void add(int... v){
        Arrays.stream(v).forEach(this::add);
    }
}


public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t = new ListNode(0), top = t;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                t = (t.next = l1);
                l1 = l1.next;
            } else {
                t = (t.next = l2);
                l2 = l2.next;
            }
        }
        if(l1 == null) t.next = l2;
        else  t.next = l1;
        return top.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5), r = new ListNode(1);
        r.add(1,2,3);
        l.print();
        r.print();
        new Solution().mergeTwoLists(l,r).print();
    }
}
