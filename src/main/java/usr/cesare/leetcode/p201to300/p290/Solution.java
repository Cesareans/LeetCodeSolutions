package usr.cesare.leetcode.p201to300.p290;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if((pattern == null) != (str == null)) return false;
        String[] words = str.split(" ");
        int l = pattern.length();
        if(words.length != l) return false;
        HashMap<Character, String> fm = new HashMap<>();
        HashMap<String, Character> bm = new HashMap<>();
        Character subC;
        String subS;
        for(int i = 0 ; i < l ; ++i){
            if((subS = fm.get(pattern.charAt(i))) != null && !subS.equals(words[i]) || (subC = bm.get(words[i])) != null && subC != pattern.charAt(i)){
                return false;
            }
            fm.put(pattern.charAt(i), words[i]);
            bm.put(words[i], pattern.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa ", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}
