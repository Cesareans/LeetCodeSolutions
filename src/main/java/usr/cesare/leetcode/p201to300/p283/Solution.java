package usr.cesare.leetcode.p201to300.p283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        for(int pnz = 0, pz = -1; pnz < nums.length ; ++pnz){
            if(nums[pnz] != 0){
                if(pz == -1) continue;
                nums[pz] = nums[pnz];
                nums[pnz] = 0;
                pz++;
            }else if(pz == -1){
                pz = pnz;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
