package usr.cesare.leetcode.p201to300.p257;

import usr.cesare.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<String> paths = new LinkedList<>(), pathStack = new LinkedList<>();
        pathStack.add("" + root.val);
        btp(root, pathStack, paths);
        return paths;
    }
    private void btp(TreeNode node, LinkedList<String> pathStack, LinkedList<String> paths){
        if(node.left == null && node.right == null) {
            paths.add(pathStack.peekLast());
            return;
        }
        if(node.left != null){
            pathStack.add(pathStack.peekLast() + "->" + node.left.val);
            btp(node.left, pathStack, paths);
            pathStack.pollLast();
        }
        if(node.right != null){
            pathStack.add(pathStack.peekLast() + "->" + node.right.val);
            btp(node.right, pathStack, paths);
            pathStack.pollLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(9);
        new Solution().binaryTreePaths(root).forEach(System.out::println);
        new Solution().binaryTreePaths(TreeNode.build(new Integer[]{})).forEach(System.out::println);
        new Solution().binaryTreePaths(TreeNode.build(new Integer[]{1, null, 2})).forEach(System.out::println);
    }
}
