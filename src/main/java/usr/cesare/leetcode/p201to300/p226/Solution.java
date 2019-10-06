package usr.cesare.leetcode.p201to300.p226;

import usr.cesare.leetcode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
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

        root.print();
        System.out.println(new Solution().invertTree(root));
        root.print();
    }
}
