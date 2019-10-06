package usr.cesare.leetcode.p1to100.p66;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int overflow = 1;
        int[] res = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; --i) {
            int r = digits[i] + overflow;
            if (r >= 10) {
                overflow = 1;
                r -= 10;
            } else {
                overflow = 0;
            }
            res[i] = r;
        }
        if (overflow == 1) {
            int[] newRes = new int[digits.length + 1];
            newRes[0] = 1;
            System.arraycopy(res, 0, newRes, 1, digits.length);
            res = newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{8, 9, 8, 9})));
    }
}
