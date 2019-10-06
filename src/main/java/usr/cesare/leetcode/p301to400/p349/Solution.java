package usr.cesare.leetcode.p301to400.p349;

import java.util.HashMap;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) map.put(i, i);
        for (int i : nums2) map.put(i, i);
        int[] res = new int[map.size()];
        int i = 0;
        for (Integer integer : map.keySet()) res[i++] = integer;
        return res;
    }
}
