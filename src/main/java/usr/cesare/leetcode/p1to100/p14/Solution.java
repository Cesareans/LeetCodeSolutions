package usr.cesare.leetcode.p1to100.p14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int tail = 0;
        while (tail < strs[0].length()) {
            char c = strs[0].charAt(tail);
            for (int i = 1; i < strs.length; ++i) {
                if (tail >= strs[i].length() || strs[i].charAt(tail) != c) {
                    return strs[0].substring(0, tail);
                }
            }
            tail++;
        }
        return strs[0].substring(0,tail);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "flower","flow","flight"
        }));
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "dog","racecar","car"
        }));
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "aa","a"
        }));
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "a","aa"
        }));
        System.out.println(new Solution().longestCommonPrefix(new String[]{
                "aa"
        }));
    }
}
