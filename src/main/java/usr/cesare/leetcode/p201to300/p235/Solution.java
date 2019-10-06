package usr.cesare.leetcode.p201to300.p235;

import usr.cesare.leetcode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode t = p;
            p = q;
            q = t;
        }
        return root.val >= p.val && root.val <= q.val ? root : lowestCommonAncestor((root.val < p.val)?root.right:root.left, p, q);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(1);
        System.out.println(new Solution().lowestCommonAncestor(root, root, root.right));
    }
}
