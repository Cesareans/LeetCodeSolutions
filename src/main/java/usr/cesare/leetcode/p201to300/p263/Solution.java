package usr.cesare.leetcode.p201to300.p263;

public class Solution {
    private static final int[] factors = new int[]{2,3,5};

    public boolean isUgly(int num) {
        if(num == 0) return false;
        for(int i = 0 ; i < 3; ){
            while (num % factors[i] == 0){
                num /= factors[i];
            }
            i++;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(1));
        System.out.println(new Solution().isUgly(2));
        System.out.println(new Solution().isUgly(3));
        System.out.println(new Solution().isUgly(4));
        System.out.println(new Solution().isUgly(5));
        System.out.println(new Solution().isUgly(6));
        System.out.println(new Solution().isUgly(7));
        System.out.println(new Solution().isUgly(8));
        System.out.println(new Solution().isUgly(9));
        System.out.println(new Solution().isUgly(21));
        System.out.println(new Solution().isUgly(14));
        System.out.println(new Solution().isUgly(11));
    }
}
