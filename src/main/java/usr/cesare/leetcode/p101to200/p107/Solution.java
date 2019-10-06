package usr.cesare.leetcode.p101to200.p107;
import usr.cesare.leetcode.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levelList = new LinkedList<>();
        if(root == null){
            return levelList;
        }
        TreeNode sentry = new TreeNode(0), t;
        LinkedList<TreeNode> levelNodes = new LinkedList<>(Arrays.asList(root, sentry));
        LinkedList<Integer> levelValues = new LinkedList<>();
        while (true){
            t = levelNodes.pollFirst();
            if(t == sentry){
                if(levelValues.size() == 0){
                    break;
                }
                levelList.add(levelValues);
                levelValues = new LinkedList<>();
                levelNodes.add(sentry);
            }else{
                levelValues.add(t.val);
                if(t.left != null) levelNodes.add(t.left);
                if(t.right != null) levelNodes.add(t.right);
            }
        }
        Collections.reverse(levelList);
        return levelList;
    }
}

class Main{
    public static void main(String[] args) {
        TreeNode tree = null;

        System.out.println(new Solution().levelOrderBottom(tree));
    }
}
