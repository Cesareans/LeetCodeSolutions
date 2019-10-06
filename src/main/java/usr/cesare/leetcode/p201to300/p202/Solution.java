package usr.cesare.leetcode.p201to300.p202;

public class Solution {
    public boolean isHappy(int n) {
        int val = 0, d;
        while (n > 0) {
            d = n % 10;
            val += d * d;
            n /= 10;
        }
        if(val >= 0 && val <=9){
            return val == 1 || val == 7;
        }

        return isHappy(val);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(1));
        System.out.println(new Solution().isHappy(2));
    }
}
