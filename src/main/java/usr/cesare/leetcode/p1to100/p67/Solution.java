package usr.cesare.leetcode.p1to100.p67;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        int cap = 0;
        int al = a.length(), bl = b.length();
        int ml = Math.max(al, bl);
        int aBin,bBin,t;
        for (int i = 1; i <= ml; ++i) {
            aBin = i>al?0:a.charAt(al-i)-48;
            bBin = i>bl?0:b.charAt(bl-i)-48;
            t = aBin+bBin+cap;
            if(t >= 2){
                t-=2;
                cap = 1;
            }else{
                cap = 0;
            }
            res.append(t);
        }
        if(cap > 0){
            res.append(cap);
        }
        return res.reverse().toString();
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("", "1"));
    }
}