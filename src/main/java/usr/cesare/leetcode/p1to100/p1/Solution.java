package usr.cesare.leetcode.p1to100.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; ++i){
            int theOther = target - nums[i];
            if(intMap.containsKey(theOther))
                return new int[]{i, intMap.get(theOther)};
            intMap.put(nums[i], i);
        }
        return null;
    }
}
