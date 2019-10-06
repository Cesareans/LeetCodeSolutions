package usr.cesare.leetcode.p101to200.p121;
// Dynamic programing
class Solution1{
    public int maxProfit(int[] prices) {
        if(prices.length <= 0) return 0;
        int[] mi = new int[prices.length];
        int max = mi[0] = 0;
        for(int i = 1 ; i < prices.length ; ++i){
            int delta = prices[i] - prices[i-1];
            mi[i] = Math.max(delta,mi[i-1]+delta);
            if(mi[i] > max){
                max = mi[i];
            }
        }
        return max;
    }
}

// Record
public class Solution {
    public int maxProfit(int[] prices) {
        int m = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0 ; i < prices.length ; ++i){
            m = Math.min(m,prices[i]);
            max = Math.max(max, prices[i] - m);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,9,7,11}));
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(new int[]{1}));
    }
}
