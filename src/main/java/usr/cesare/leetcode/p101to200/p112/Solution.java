package usr.cesare.leetcode.p101to200.p112;

import usr.cesare.leetcode.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int val) {
        val += root.val;
        return root.left != null && hasPathSum(root.left, sum, val) ||
                root.right != null && hasPathSum(root.right, sum, val) ||
                root.left == null && root.right == null && val == sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution().hasPathSum(root,5));
    }
}
