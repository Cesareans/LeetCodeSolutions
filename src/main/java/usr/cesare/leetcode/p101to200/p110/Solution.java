package usr.cesare.leetcode.p101to200.p110;


import usr.cesare.leetcode.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanceDepth(root) != -1;
    }

    public int balanceDepth(TreeNode root) {
        if (root == null) return 0;
        int ld = balanceDepth(root.left);
        int rd = balanceDepth(root.right);
        if (ld == -1 || rd == -1 || Math.abs(rd - ld) > 1)  return -1;
        return Math.max(ld, rd) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution().isBalanced(root));
    }
}
