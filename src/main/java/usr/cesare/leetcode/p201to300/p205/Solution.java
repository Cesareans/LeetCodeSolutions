package usr.cesare.leetcode.p201to300.p205;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if((s == null) != (t == null)) return false;
        int l = s.length();
        if(t.length() != l) return false;
        HashMap<Character, Character> fm = new HashMap<>(), bm = new HashMap<>();
        Character ct;
        for(int i = 0 ; i < l ; ++i){
            if((ct = fm.get(s.charAt(i))) != null && ct != t.charAt(i) || (ct = bm.get(t.charAt(i))) != null && ct != s.charAt(i)){
                return false;
            }
            fm.put(s.charAt(i), t.charAt(i));
            bm.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("ab", "aa"));
        System.out.println(solution.isIsomorphic("egg", "add")); // true
        System.out.println(solution.isIsomorphic("foo", "bar")); // false
        System.out.println(solution.isIsomorphic("paper", "title")); // true
        System.out.println(solution.isIsomorphic("", ""));
        System.out.println(solution.isIsomorphic(null, "add"));
    }
}
