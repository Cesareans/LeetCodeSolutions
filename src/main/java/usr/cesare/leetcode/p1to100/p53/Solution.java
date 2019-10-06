package usr.cesare.leetcode.p1to100.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        Integer max = null;
        int cur = 0;
        for (int num : nums) {
            cur = Integer.max(cur + num, num);
            if (max == null || cur > max) {
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{-2}));
        System.out.println(new Solution().maxSubArray(new int[]{}));
    }
}
