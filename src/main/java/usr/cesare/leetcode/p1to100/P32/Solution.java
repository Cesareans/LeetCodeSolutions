package usr.cesare.leetcode.p1to100.P32;

import java.util.LinkedList;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        int[] signs = new int[s.length()];
        LinkedList<Integer> left = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                left.add(i);
            } else if (s.charAt(i) == ')') {
                Integer lidx = left.pollLast();
                if (lidx != null) {
                    signs[lidx] = 1;
                    signs[i] = 1;
                }
            }
        }
        int c = 0, m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (signs[i] == 1) {
                c++;
                if (c > m) {
                    m = c;
                }
            } else if (signs[i] == 0) {
                c = 0;
            }
        }
        return m;
    }
}

class DPSolution {

    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        int[] dp = new int[s.length()];
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i > 0) {
                int t = i - 1 - dp[i - 1];
                if (t >= 0 && s.charAt(t) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (t - 1 >= 0) {
                        dp[i] += dp[t - 1];
                    }
                }
            }
            if (dp[i] > m) {
                m = dp[i];
            }
        }
        return m;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()()"));
        System.out.println(new Solution().longestValidParentheses(")()())()()(())"));
        System.out.println(new Solution().longestValidParentheses(""));
        System.out.println(new Solution().longestValidParentheses(null));
        System.out.println();
        System.out.println(new DPSolution().longestValidParentheses("(()"));
        System.out.println(new DPSolution().longestValidParentheses(")()())"));
        System.out.println(new DPSolution().longestValidParentheses("()()"));
        System.out.println(new DPSolution().longestValidParentheses(")()())()()(())"));
        System.out.println(new DPSolution().longestValidParentheses(""));
        System.out.println(new DPSolution().longestValidParentheses(null));
    }
}