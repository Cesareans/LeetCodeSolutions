package usr.cesare.leetcode.p101to200.p189;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int s, int e){
        while (s < e){
            int i = nums[s];
            nums[s] = nums[e];
            nums[e] = i;
            s++;e--;
        }
    }

    public static void main(String[] args) {
        int [] arrays = new int[]{1,2,3,4};
        new Solution().rotate(arrays, 1);
        System.out.println(Arrays.toString(arrays));
    }
}
