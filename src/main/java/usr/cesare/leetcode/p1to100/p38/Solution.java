package usr.cesare.leetcode.p1to100.p38;

import java.util.stream.IntStream;

public class Solution {
    String[] cs = new String[30];
    {
        cs[0] = "1";
        cs[1] = "11";
        cs[2] = "21";
        cs[3] = "1211";
        cs[4] = "111221";
    }
    private String convert(String str){
        StringBuilder builder = new StringBuilder();
        for(int j = 0 ; j < str.length();){
            int n = 1; char c = str.charAt(j++);
            for(; j < str.length() && str.charAt(j) == c; ++j, ++n);
            builder.append(n).append(c);
        }
        return builder.toString();
    }
    public String countAndSay(int n) {
        if(cs[n-1] == null)  cs[n-1] = convert(countAndSay(n-1));
        return cs[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        IntStream.rangeClosed(1,30).forEach(i->{
            System.out.println(solution.countAndSay(i));
        });
    }
}
