package usr.cesare.leetcode.p1to100.p23;

import usr.cesare.leetcode.ListNode;

import java.util.*;
import java.util.logging.Level;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode head = minHeap.poll(), node = head;
        if (head != null && head.next != null) {
            minHeap.add(head.next);
        }
        while (minHeap.size() > 0) {
            node.next = minHeap.poll();
            node = node.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return head;
    }
}

class Solution1{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return merge(0, lists.length - 1, lists);
    }

    public ListNode merge(int l, int r, ListNode[] lists){
        if(l == r){
            return lists[l];
        }
        int mid = (l + r) / 2;
        ListNode left = merge(l, mid, lists);
        ListNode right = merge(mid + 1, r, lists);

        ListNode head = new ListNode(0), node = head;
        while (left != null && right != null){
            if(left.val > right.val){
                node.next = right;
                right = right.next;
            }else{
                node.next = left;
                left = left.next;
            }
            node = node.next;
        }
        node.next = left==null?right:left;
        return head.next;
    }
}
class Main {
    public static void main(String[] args) {
        System.out.println(new Solution1().mergeKLists(null));
        System.out.println(new Solution1().mergeKLists(new ListNode[]{
                ListNode.build(new int[]{}),
                ListNode.build(new int[]{1,2,3}),
                ListNode.build(new int[]{1,4,6}),
        }));
        System.out.println(new Solution1().mergeKLists(new ListNode[]{
                ListNode.build(new int[]{1,2,3}),
                ListNode.build(new int[]{3,4,5}),
                ListNode.build(new int[]{1,2,3}),
                ListNode.build(new int[]{1,2,3}),
        }));
    }
}
