package usr.cesare.leetcode.p201to300.p299;

import java.util.HashMap;
import java.util.function.BiFunction;

class BestSolution{
    public String getHint(String secret, String guess) {
        int[] s = new int[10], g = new int[10];
        int bulls = 0;
        for(int i=0; i < secret.length(); i++){
            char ch1 = secret.charAt(i), ch2 = guess.charAt(i);
            if(ch1 == ch2)
                ++bulls;
            else{
                s[ch1-'0']++;
                g[ch2-'0']++;
            }
        }
        int cows = 0;
        for(int i=0; i < s.length; i++)
            cows += Math.min(s[i], g[i]);
        return bulls+"A"+cows+"B";
    }
}

public class Solution {
    private static final BiFunction<Character, Integer, Integer> calv = (k, v) -> v == null ? 1 : v + 1;
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> aTimes = new HashMap<>(), bTimes = new HashMap<>();
        int l = secret.length(), a = 0, b = 0;
        Integer t;
        char s, g;
        for (int i = 0; i < l; ++i) {
            if ((s = secret.charAt(i)) == (g = guess.charAt(i))) ++a;
            else {
                if ((t = aTimes.get(g)) != null && t > 0) {
                    b++;
                    aTimes.replace(g, t - 1);
                } else {
                    bTimes.compute(g, calv);
                }
                if ((t = bTimes.get(s)) != null && t > 0) {
                    b++;
                    bTimes.replace(s, t - 1);
                } else {
                    aTimes.compute(s, calv);
                }
            }
        }
        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
        System.out.println(new Solution().getHint("1123", "0111"));
        System.out.println(new Solution().getHint("1234", "5678"));
    }
}
