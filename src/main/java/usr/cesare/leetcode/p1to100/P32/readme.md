# LeetCode Solution P32-Longest Valid Parentheses
栈：Time @ `O(n)` Space @ `O(n)` 常数因子较高
    
    使用栈进行左括号下标处理，每遇到一个')'则匹配栈中的'('
    并使用一个额外的数组存储匹配括号，最后对该额外数组进行收集计算

```java
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        int[] signs = new int[s.length()];
        LinkedList<Integer> left = new LinkedList<>();

        for(int i = 0 ; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                left.add(i);
            } else if(s.charAt(i) == ')'){
                Integer lidx = left.pollLast();
                if(lidx != null) {
                    signs[lidx] = 1;
                    signs[i] = 1;
                }
            }
        }
        int c = 0 , m = 0;
        for(int i = 0 ; i < s.length(); ++i){
            if(signs[i] == 1){
                c++;
                if(c > m){
                    m = c;
                }
            }else if(signs[i] == 0){
                c = 0;
            }
        }
        return m;
    }
}
```

DP：Time @ `O(n)` Space @ `O(n)` 常数因子较低

    记录额外数组dp[n]，每个位置记录当前最长匹配
    应有每个')'下标i所在值（i - dp[i - 1] - 1）即为对应的位置，记为t
    有递推公式
    for i in n:
        dp[i] = 0 , s[i] == '(' || i == 0 || t < 0 || s[t] == ')'
        dp[i] = dp[i-1] + 2 , t > 0 && s[t] == '('
        dp[i] = dp[t-1] + dp[i-1] + 2 , t > 0 && s[t] == '(' && t-1>0
    
```java
class Solution {
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
```