package usr.cesare.leetcode.p101to200.p125;

class Solution {
    private static final int diff = 32;
    public boolean isPalindrome(String s) {
        char lc = 0, rc = 0;
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            while (l < r && isNotAlphaNumeric(lc = s.charAt(l))) l++;
            while (l < r && isNotAlphaNumeric(rc = s.charAt(r))) r--;
            if (l >= r) return true;
            if (toLowerCase(lc) != toLowerCase(rc)) return false;
        }
        return true;
    }

    private boolean isNotAlphaNumeric(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    private char toLowerCase(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c+diff);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("\"0P\""));
        System.out.println(new Solution().isPalindrome("\"OP\""));
    }
}
