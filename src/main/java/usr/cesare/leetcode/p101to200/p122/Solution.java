package usr.cesare.leetcode.p101to200.p122;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0,min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max += prices[i] - min;
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1})); // 0
        System.out.println(new Solution().maxProfit(new int[]{1})); // 0
        System.out.println(new Solution().maxProfit(new int[]{})); // 0
    }
}
