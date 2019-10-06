package usr.cesare.leetcode.p101to200.p101;

import usr.cesare.leetcode.TreeNode;

import java.util.LinkedList;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> checkList = new LinkedList<>();
        checkList.add(root.left);
        checkList.add(root.right);
        while (checkList.size() > 0) {
            TreeNode left = checkList.pollFirst();
            TreeNode right = checkList.pollFirst();
            if ((left != null && right != null && left.val != right.val) || (left == null) != (right == null)) {
                return false;
            } else if(left !=null){
                checkList.add(left.left);
                checkList.add(right.right);
                checkList.add(left.right);
                checkList.add(right.left);
            }
        }
        return true;
    }
}

class Solution1{
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode ln, TreeNode rn){
        if(ln == null && rn==null){
            return true;
        }
        if(ln != null && rn != null && ln.val == rn.val){
            return isSymmetric(ln.left,rn.right) && isSymmetric(ln.right,rn.left);
        }
        return false;
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(9);
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.right = new TreeNode(12);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution().isSymmetric(root));
    }
}
