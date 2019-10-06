package usr.cesare.leetcode.p101to200.p136;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums){
            res ^= nums[i];
        }
        return res;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2,2,1}));
    }
}
