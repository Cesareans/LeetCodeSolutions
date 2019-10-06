package usr.cesare.leetcode.p1to100.p27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums,  int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0;
        for(int i = 0 ; i < nums.length ; ++i){
            if(nums[i] != val){
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1 };
        System.out.println(new Solution().removeElement(nums, 0));
        System.out.println(Arrays.toString(nums));
    }
}