package usr.cesare.leetcode.p1to100.p88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m - 1, ni = n - 1, i = m + n - 1;
        while (i >= 0 && ni >= 0) {
            if (mi < 0) {
                nums1[i--] = nums2[ni--];
            } else {
                if (nums1[mi] > nums2[ni]) {
                    nums1[i--] = nums1[mi--];
                } else {
                    nums1[i--] = nums2[ni--];
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] num1 = new int[]{2,0};
        int[] num2 = new int[]{1};
        new Solution().merge(num1, 1, num2, 1);
        System.out.println(Arrays.toString(num1));
    }
}