package usr.cesare.leetcode.p301to400.p342;

public class Solution {
    public boolean isPowerOfFour(int num) {
        // 1 bit
        if(num <= 0 || (num & num - 1) != 0) return false;
        for(int i = 1; num != 0; num >>= 2) if((num & i) == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(4));
        System.out.println(new Solution().isPowerOfFour(0));
        System.out.println(new Solution().isPowerOfFour(1));
        System.out.println(new Solution().isPowerOfFour(2));
        System.out.println(new Solution().isPowerOfFour(8));
        System.out.println(new Solution().isPowerOfFour(16));
    }
}
