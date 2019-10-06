package usr.cesare.leetcode.p101to200.p198;

public class Solution {
    public int rob(int[] nums) {
        int pre1 = 0 , prev2 = 0, max = 0;
        for(int i = 0 ; i < nums.length ; ++i){
            max = Math.max(nums[i] + prev2, pre1);
            prev2 = pre1;
            pre1 = max;
        }
        return max;
    }

    // With extra space
    public int rob2(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int[] m = new int[nums.length];
        for(int i = 0 ; i < nums.length ; ++i){
            m[i] = Math.max(nums[i] + (i >= 2 ? m[i-2]:0), (i >= 1 ? m[i-1]:0));
        }
        return m[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob2(new int[]{1,2,3,1}));
        System.out.println(new Solution().rob2(new int[]{2,7,9,3,1}));
    }

}
