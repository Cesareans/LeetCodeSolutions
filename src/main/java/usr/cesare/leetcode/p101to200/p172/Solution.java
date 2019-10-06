package usr.cesare.leetcode.p101to200.p172;

public class Solution {
    public int trailingZeroes(int n) {
        int c = 0;
        for(int i = 0 ; i <= n && i >= 0; i += 5){
            int t = i;
            while (t >= 5 && t % 5 == 0) {
                ++c;
                t /= 5;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(1));
        System.out.println(new Solution().trailingZeroes(5));
        System.out.println(new Solution().trailingZeroes(2));
        System.out.println(new Solution().trailingZeroes(10));
        System.out.println(new Solution().trailingZeroes(25));
        System.out.println(new Solution().trailingZeroes(2147483));
        System.out.println(new Solution().trailingZeroes(21474836));
        System.out.println(new Solution().trailingZeroes(2147483641));
        System.out.println(new Solution().trailingZeroes(2147483647));
    }
}
