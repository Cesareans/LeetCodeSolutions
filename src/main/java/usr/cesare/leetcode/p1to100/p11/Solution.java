package usr.cesare.leetcode.p1to100.p11;

public class Solution {
    public int maxArea(int[] height) {
        int l, r, m = 0;
        for (l = 0, r = height.length - 1; l < r; ) {
            m = Math.max(m, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new Solution().maxArea(new int[]{1,2,3,4,5}));
    }
}