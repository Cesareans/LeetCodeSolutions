package usr.cesare.leetcode.p1to100.p5;

public class Solution {
    public String longestPalindrome(String s) {
        int len = 2 * s.length() + 1;
        char[] str = new char[len];
        for (int i = 1; i < len; i += 2) {
            str[i] = s.charAt((i - 1) / 2);
        }
        int[] arr = new int[len];
        int m = 0, l , r;
        arr[m] = 1;
        for (int i = 1; i < len; i++) {
            if (i >= m + arr[m]) {
                for (l = i - 1, r = i + 1; l >= 0 && r < len; l--, r++) {
                    if (str[l] != str[r]) {
                        break;
                    }
                }
                arr[i] = i - l;
                if (arr[i] > arr[m]) {
                    m = i;
                }
            } else {
                if (arr[2 * m - i] < arr[m] - i + m) {
                    arr[i] = arr[2*m-i];
                }else{
                    for (r = m + arr[m], l = 2 * i - r; l >= 0 && r < len; l--, r++) {
                        if (str[l] != str[r]) {
                            break;
                        }
                    }
                    arr[i] = i - l;
                    if (arr[i] > arr[m]) {
                        m = i;
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        l = m - arr[m] + 1;
        r = m + arr[m] - 1;
        for(int i = l ; i <= r; ++i){
            if(i % 2 == 1){
                builder.append(str[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("aaba"));
        System.out.println(new Solution().longestPalindrome("aabaa"));
        System.out.println(new Solution().longestPalindrome("aabaaababa"));
        System.out.println(new Solution().longestPalindrome("aabaa"));
    }
}
