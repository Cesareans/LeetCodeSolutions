package usr.cesare.leetcode.p1to100.p70;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> resList = new ArrayList<>();
    {
        resList.add(1);
        resList.add(1);
        resList.add(2);
    }
    public int climbStairs(int n) {
        if(resList.size() <= n){
            resList.add(climbStairs(n-1)+climbStairs(n-2));
        }
        return resList.get(n);
    }
}

class Main{
    public static void main(String[] args) {
        for(int i = 1 ; i <= 100 ; ++i){
            System.out.println(new Solution().climbStairs(i));
        }
    }
}
