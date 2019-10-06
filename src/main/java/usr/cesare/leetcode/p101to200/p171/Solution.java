package usr.cesare.leetcode.p101to200.p171;

public class Solution {
    public int titleToNumber(String s) {
        if(s == null) return 0;
        int res = 0;
        for(int i = 0 ; i < s.length() ; ++i){
            res = res*26+s.charAt(i)-64;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("ZY"));
        System.out.println(new Solution().titleToNumber("A"));
        System.out.println(new Solution().titleToNumber("AA"));
        System.out.println(new Solution().titleToNumber("AB"));
    }
}
