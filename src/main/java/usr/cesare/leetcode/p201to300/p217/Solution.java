package usr.cesare.leetcode.p201to300.p217;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int num : nums) {
            if(integerHashSet.contains(num)) return true;
            integerHashSet.add(num);
        }
        return false;
    }
}
