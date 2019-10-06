package usr.cesare.leetcode.p1to100.p100;

import usr.cesare.leetcode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return q == null && p == null || (q == null) == (p == null) && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class Solution1{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list1 = new LinkedList<>(Collections.singletonList(p));
        LinkedList<TreeNode> list2 = new LinkedList<>(Collections.singletonList(q));
        while (list1.size() > 0 && list2.size() > 0){
            TreeNode n1 = list1.pollFirst();
            TreeNode n2 = list2.pollFirst();
            if(n1==null && n2==null){
                continue;
            }
            if((n1 == null) != (n2 == null)){
                return false;
            }
            if(n1.val != n2.val){
                return false;
            }
            list1.add(n1.left);list1.add(n1.right);
            list2.add(n2.left);list2.add(n2.right);
        }
        return list1.size() == 0 && list2.size() == 0;
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println(new Solution1().isSameTree(tree1,tree2));
    }
}
