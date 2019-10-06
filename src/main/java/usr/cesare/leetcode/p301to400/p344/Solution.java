package usr.cesare.leetcode.p301to400.p344;

public class Solution {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length - 1; i < j; ++i,--j){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
