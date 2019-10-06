package usr.cesare.leetcode.p101to200.p190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int t, res = 0;
        for(int i = 31 ; i >= 0 ; --i){
            t = n & 1;
            n >>>= 1;
            res |= t << (i);
            if(n == 0) break;
        }
        return res;
    }
    private void print(int i){
        StringBuilder builder = new StringBuilder();
        while (i!=0){
            builder.append(i&1);
            i>>>=1;
        }
        int bi = builder.length();
        for(int j = bi; j < 32; ++j){
            builder.append(0);
        }
        System.out.println(builder.reverse().toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.print(1431655765);
        s.print(858993459);
        s.print(252645135);
    }
}