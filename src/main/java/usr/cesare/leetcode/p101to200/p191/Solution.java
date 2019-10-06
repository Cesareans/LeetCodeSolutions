package usr.cesare.leetcode.p101to200.p191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public int bitCount(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(5));
    }
}
