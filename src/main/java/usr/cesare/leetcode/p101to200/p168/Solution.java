package usr.cesare.leetcode.p101to200.p168;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int i = n % 26;
            n = n / 26;
            sb.append((char) (i + 65));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(1));
        System.out.println(new Solution().convertToTitle(2));
        System.out.println(new Solution().convertToTitle(16));
        System.out.println(new Solution().convertToTitle(28));
        System.out.println(new Solution().convertToTitle(52));
        System.out.println(new Solution().convertToTitle(701));
    }
}
