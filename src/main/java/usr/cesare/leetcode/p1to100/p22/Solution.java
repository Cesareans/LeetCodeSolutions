package usr.cesare.leetcode.p1to100.p22;

import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, 0, n, "");
        return res;
    }

    private void generateParenthesis(List<String> l, int left, int right, int n, String s) {
        if (s.length() == 2 * n) {
            l.add(s);
            return;
        }
        if (left < n) {
            generateParenthesis(l, left + 1, right, n, s + "(");
        }
        if (left > right) {
            generateParenthesis(l, left, right + 1, n, s + ")");
        }
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(1));
        System.out.println(new Solution().generateParenthesis(2));
        System.out.println(new Solution().generateParenthesis(3));
    }
}