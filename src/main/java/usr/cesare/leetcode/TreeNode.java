package usr.cesare.leetcode;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode build(Integer[] nums) {
        if (nums == null) return null;
        return buildNode(nums, 0);
    }

    private static TreeNode buildNode(Integer[] nums, int c) {
        if (c >= nums.length || nums[c] == null) return null;
        TreeNode tn = new TreeNode(nums[c]);
        tn.left = buildNode(nums, 2 * c + 1);
        tn.right = buildNode(nums, 2 * c + 2);
        return tn;
    }

    public void print() {
        LinkedList<TreeNode> traversal = new LinkedList<>();
        TreeNode sentry = new TreeNode(0);
        traversal.add(this);
        traversal.add(sentry);
        StringBuilder builder = new StringBuilder();
        boolean hasNoneNull = false;
        while (traversal.size() > 0) {
            TreeNode treeNode = traversal.pollFirst();
            if (treeNode == sentry) {
                if(hasNoneNull) {
                    System.out.println(builder.substring(0, builder.length() - 3));
                    hasNoneNull = false;
                    builder = new StringBuilder();
                    traversal.add(sentry);
                }else{
                    break;
                }
            } else if (treeNode != null) {
                hasNoneNull = true;
                builder.append(treeNode.val).append(" + ");
                traversal.add(treeNode.left);
                traversal.add(treeNode.right);
            } else {
                builder.append("null + ");
                traversal.add(null);
                traversal.add(null);
            }
        }
    }
}
