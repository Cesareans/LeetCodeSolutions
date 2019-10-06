package usr.cesare.leetcode.p1to100.p28;

import java.util.Random;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int i = 0, j, l = haystack.length() - needle.length() + 1;
        for (; i < l; ++i) {
            for (j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}

class HashSolution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int needleHash = 0, hayHash = 0;
        int nl = needle.length(), hl = haystack.length(), del = hl - nl;
        for(int i = 0 ; i < nl ; ++i){
            needleHash += needle.charAt(i);
            hayHash += haystack.charAt(i);
        }
        for(int i = 0 ; i <= del ; ++i){
            if(i != 0){
                hayHash -= haystack.charAt(i - 1);
                hayHash += haystack.charAt(i + nl - 1);
            }
            if(hayHash == needleHash){
                int j = 0;
                for(; j < nl ; ++j){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                }
                if(j == nl){
                    return i;
                }
            }
        }
        return -1;
    }
}


class KMPSolution {
    int[] next(String needle) {
        if (needle.length() <= 0) {
            throw new RuntimeException("KMP does not support empty string.");
        }
        int next[] = new int[needle.length() + 1];
        next[0] = -1;
        for (int i = 0, j = -1; i < needle.length(); ) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = next(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        String hay = StringMixer.mix(10000000, 'A', 'C', 'G', 'T');
        String needle = hay.substring(hay.length()/10, hay.length()/2);
        System.out.println(hay);
        System.out.println(needle);

        long pre = System.currentTimeMillis(), now;
        System.out.println(hay.indexOf(needle) + " : ");
        System.out.println((now = System.currentTimeMillis()) - pre);
        pre = now;

        System.out.println(new Solution().strStr(hay, needle) + " : ");
        System.out.println((now = System.currentTimeMillis()) - pre);
        pre = now;


        System.out.println(new KMPSolution().strStr(hay, needle) + " : ");
        System.out.println((now = System.currentTimeMillis()) - pre);
        pre = now;


        System.out.println(new HashSolution().strStr(hay, needle) + " : ");
        System.out.println((now = System.currentTimeMillis()) - pre);
        pre = now;
    }
}

class StringMixer {
    public static String mix(int len, char... chars){
        int cl = chars.length;
        StringBuilder builder = new StringBuilder();
        Random rd = new Random();
        for(int i = 0 ; i < len; ++i){
            builder.append(chars[rd.nextInt(cl)]);
        }
        return builder.toString();
    }
}