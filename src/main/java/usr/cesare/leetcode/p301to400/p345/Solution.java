package usr.cesare.leetcode.p301to400.p345;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    private static final HashSet<Character> charSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public String reverseVowels(String s) {
        char t;
        StringBuilder builder = new StringBuilder(s);
        for(int i = 0, j = s.length() - 1; i < j; ++i,--j){
            while (!charSet.contains(Character.toLowerCase(s.charAt(i))) && i < j) ++i;
            while (!charSet.contains(Character.toLowerCase(s.charAt(j))) && i < j) --j;
            t = builder.charAt(i);
            builder.setCharAt(i, builder.charAt(j));
            builder.setCharAt(j, t);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
        System.out.println(new Solution().reverseVowels("leetcode"));
        System.out.println(new Solution().reverseVowels("aA"));
    }
}