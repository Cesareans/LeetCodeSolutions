package usr.cesare.leetcode.p1to100.p15;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    private static HashMap<Character, Character> sets = new HashMap<>();

    static {
        sets.put('(', ')');
        sets.put('[', ']');
        sets.put('{', '}');
    }

    public boolean isValid(String s) {
        LinkedList<Character> characters = new LinkedList<>();
        Character c;
        for (int i = 0; i < s.length(); ++i) {
            if (sets.containsKey(c = s.charAt(i))) {
                characters.push(c);
            } else {
                if (characters.size() == 0 || !sets.get(characters.poll()).equals(c)) {
                    return false;
                }
            }
        }
        return characters.size() <= 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("[]"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
        System.out.println(new Solution().isValid(""));
        System.out.println(new Solution().isValid("]"));
    }
}
