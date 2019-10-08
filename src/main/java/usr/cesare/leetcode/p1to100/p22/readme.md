# LeetCode Solution P22-Generate Parentheses
递归回溯：
    
    1. 当左括号数量小于N时，可向下递归，增加左括号
    2. 当右括号数量小雨左括号数量时，可向下递归，增加右括号
    
```java
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
```
