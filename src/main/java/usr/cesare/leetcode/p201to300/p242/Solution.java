package usr.cesare.leetcode.p201to300.p242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] occurs = new int[26];
        int l = s.length();
        if(l != t.length()) return false;
        for(int i = 0 ; i < l; ++i){
            occurs[s.charAt(i) - 'a']++;
            occurs[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < 26 ; ++i){
            if(occurs[i] > 0){
                return false;
            }
        }
        return true;
    }
}
