package usr.cesare.leetcode.p1to100.p8;

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
class Main{
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("123"));
        System.out.println(new Solution().myAtoi("  "));
        System.out.println(new Solution().myAtoi("-123"));
        System.out.println(new Solution().myAtoi("   123"));
        System.out.println(new Solution().myAtoi("   -123"));
        System.out.println(new Solution().myAtoi("   -1232ww"));
        System.out.println(new Solution().myAtoi("   2w-1232ww"));
        System.out.println(new Solution().myAtoi(" w22w-1232ww"));
        System.out.println(new Solution().myAtoi(" -91283472332"));
        System.out.println(new Solution().myAtoi(" 91283472332"));
    }
}