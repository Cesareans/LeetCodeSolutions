package usr.cesare.leetcode.p201to300.p231;

class Solution {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(0));
        System.out.println(new Solution().isPowerOfTwo(1));
        System.out.println(new Solution().isPowerOfTwo(2));
        System.out.println(new Solution().isPowerOfTwo(3));
        System.out.println(new Solution().isPowerOfTwo(4));
        System.out.println(new Solution().isPowerOfTwo(5));
        System.out.println(new Solution().isPowerOfTwo(8));
    }
}