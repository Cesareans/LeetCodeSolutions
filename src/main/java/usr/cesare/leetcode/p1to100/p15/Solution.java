package usr.cesare.leetcode.p1to100.p15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        int mid = 0;
        for (; mid < nums.length; mid++) {
            if (nums[mid] >= 0) {
                break;
            }
        }
        int zeroCount = 0;
        for (int i = mid; i < nums.length; ++i) {
            if (nums[i] > 0) {
                break;
            }else if(nums[i] == 0){
                zeroCount++;
            }
        }
        if (zeroCount >= 3) {
            results.add(Arrays.asList(0, 0, 0));
        }

        for(int l = mid - 1; l >= 0&&l<nums.length-1 ; l--){
            if(nums[l] == nums[l+1]) continue;
            for(int r = mid; r < nums.length;++r){
                if(nums[r] == nums[r-1]) continue;
                int need = -nums[l] - nums[r];
                int idx;
                if (need < 0) {
                    idx = Arrays.binarySearch(nums, 0, l, need);
                } else {
                    idx = Arrays.binarySearch(nums, r+1, nums.length, need);
                }
                if (idx >= 0) {
                    results.add(Arrays.asList(nums[l], nums[r], nums[idx]));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{0,0,0}));
        System.out.println(new Solution().threeSum(new int[]{-1,-2,-3,-4}));
        System.out.println(new Solution().threeSum(new int[]{1,2,3,4}));
        System.out.println(new Solution().threeSum(new int[]{-1,0}));
        System.out.println(new Solution().threeSum(new int[]{0,0,0}));
        System.out.println(new Solution().threeSum(new int[]{-1,0,1}));
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{-1, 0,0,0, 1, 2, -1, -4}));
    }
}
