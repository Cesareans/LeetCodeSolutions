package usr.cesare.leetcode.p201to300.p236;

import usr.cesare.leetcode.TreeNode;

import java.util.LinkedList;

public class Solution {
    boolean meet = false;
    TreeNode next;
    LinkedList<TreeNode> treeNodes = new LinkedList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (meet && root == next) return treeNodes.pollLast();
        if (!meet) {
            treeNodes.add(root);
            if (root == p) {
                next = q;
                meet = true;
            } else if (root == q) {
                next = p;
                meet = true;
            }
        }
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node == null) {
            node = lowestCommonAncestor(root.right, p, q);
        }
        if (!meet || treeNodes.peekLast() == root) {
            treeNodes.pollLast();
        }
        return node;
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

    }
}
