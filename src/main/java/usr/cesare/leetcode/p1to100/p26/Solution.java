package usr.cesare.leetcode.p1to100.p26;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0;
        for(int i = 0 ; i < nums.length ; ++i){
            if(nums[i] > nums[len]){
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}