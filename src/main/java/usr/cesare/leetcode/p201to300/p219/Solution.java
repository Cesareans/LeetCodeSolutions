package usr.cesare.leetcode.p201to300.p219;

import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
    class Node{
        public int v,idx;

        public Node(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 0) return false;
        TreeSet<Node> treeSet = new TreeSet<>((pre, post)-> pre.v == post.v ? pre.idx - post.idx : pre.v - post.v);
        for (int i = 0; i < nums.length; i++)  treeSet.add(new Node(nums[i], i));
        Iterator<Node> it = treeSet.descendingIterator();
        Node cur = it.next();
        while (it.hasNext()){
            Node lower = it.next();
            if(cur.v == lower.v && (cur.idx - lower.idx) <= k) return true;
            cur = lower;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 1));
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 1));
    }
}
