package usr.cesare.leetcode.p101to200.p111;

import usr.cesare.leetcode.TreeNode;

public class Solution {
    private int minDepth;

    public int minDepth(TreeNode root) {
        minDepth = Integer.MAX_VALUE;
        if(root == null) return 0;
        minDepth(root, 0);
        return minDepth;
    }

    private void minDepth(TreeNode root, int depth) {
        depth += 1;
        if (root.left == null && root.right == null && depth < minDepth) {
            minDepth = depth;
        }
        if (root.left != null) {
            minDepth(root.left, depth);
        }
        if (root.right != null) {
            minDepth(root.right, depth);
        }
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


        System.out.println(new Solution().minDepth(null));
    }
}
