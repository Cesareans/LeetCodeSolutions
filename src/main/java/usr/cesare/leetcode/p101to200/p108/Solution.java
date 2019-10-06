package usr.cesare.leetcode.p101to200.p108;

import usr.cesare.leetcode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l > r) return null;
        int m = (l+r)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBST(nums, l, m-1);
        root.right = sortedArrayToBST(nums, m+1, r);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{1,2,3});
        if(treeNode != null){
            treeNode.print();
        }else{
            System.out.println("null");
        }
    }
}
