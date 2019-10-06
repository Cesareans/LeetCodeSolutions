package usr.cesare.leetcode.p101to200.p167;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int t, r, lm1 = numbers.length - 1;
        for (int i = 0; i < lm1;++i) {
            if(i > 0){
                i = findExactlyBigger(numbers, numbers[i-1],i,lm1);
            }
            t = target - numbers[i];
            if ((r = findTarget(numbers, t, i + 1, lm1)) != -1) {
                return new int[]{i + 1, r + 1};
            }
        }
        return null;
    }

    private int findExactlyBigger(int[] numbers, int target, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (numbers[mid] > target && numbers[mid - 1] == target) return mid;

        if (numbers[mid] > target) return findExactlyBigger(numbers, target, l, mid - 1);
        else return findExactlyBigger(numbers, target, mid + 1, r);
    }

    private int findTarget(int[] numbers, int target, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (numbers[mid] == target) return mid;
        else if(numbers[mid] > target) return findTarget(numbers, target, l, mid - 1);
        else return findTarget(numbers, target, mid + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{}, 5)));
    }
}
