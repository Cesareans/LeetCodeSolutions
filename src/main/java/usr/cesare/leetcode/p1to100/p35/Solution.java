package usr.cesare.leetcode.p1to100.p35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = -1;
        while (++i < nums.length && nums[i] < target) ;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1}, 1));
    }
}