# LeetCode Solution P8-String to Integer (atoi)
经典atoi问题：
    
    注意各种转换的边界条件即可【我已经错了无数遍】
    
```java
public class Solution {
    public int myAtoi(String str) {
        if (str.length() <= 0) return 0;
        boolean isPositive = true;
        long res = 0;
        int idx = 0;
        while (str.charAt(idx) == ' ') {
            idx++;
            if(idx >= str.length()){
                return 0;
            }
        }
        if (str.charAt(idx) == '-') {
            isPositive = false;
            idx++;
        }else if (str.charAt(idx) == '+') {
            idx++;
        }
        for (; idx < str.length(); ++idx) {
            char c = str.charAt(idx);
            if (c >= '0' && c <= '9') {
                res = res * 10 + c - '0';
                if(res > Integer.MAX_VALUE){
                    return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (isPositive ? 1 : -1) * (int)res;
    }
}
```