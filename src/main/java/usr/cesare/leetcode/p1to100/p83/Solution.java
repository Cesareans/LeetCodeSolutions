package usr.cesare.leetcode.p1to100.p83;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur;
        while ((cur = pre.next) != null) {
            if(pre.val == cur.val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
        }
        return head;
    }
}

class Main{
    public static void main(String[] args) {
        ListNode node = new ListNode(1), head = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        new Solution().deleteDuplicates(head);
        while (head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
    }
}
