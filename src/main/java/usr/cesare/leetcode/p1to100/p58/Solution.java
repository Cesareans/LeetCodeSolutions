package usr.cesare.leetcode.p1to100.p58;

class Solution {
    public int lengthOfLastWord(String s) {
        int l = 0;
        boolean wordDetect = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) != ' '){
                wordDetect = true;
                l++;
            }else if(wordDetect){
                break;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello world"));
        System.out.println(new Solution().lengthOfLastWord("world"));
        System.out.println(new Solution().lengthOfLastWord("hello "));
        System.out.println(new Solution().lengthOfLastWord("w or ld "));
        System.out.println(new Solution().lengthOfLastWord(""));
    }
}
