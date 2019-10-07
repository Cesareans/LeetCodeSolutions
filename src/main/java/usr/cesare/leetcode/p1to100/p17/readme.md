# LeetCode Solution P17-Letter Combinations of a Phone Number
递归解法：
    
    普通回溯递归即可，不过在数字较长的情况下容易栈溢出，应该可以试一下循环
    
```java
public class Solution {
    private final char[][] keyboard = new char[10][];
    {
        keyboard[2] = new char[]{'a','b','c'};
        keyboard[3] = new char[]{'d','e','f'};
        keyboard[4] = new char[]{'g','h','i'};
        keyboard[5] = new char[]{'j','k','l'};
        keyboard[6] = new char[]{'m','n','o'};
        keyboard[7] = new char[]{'p','q','r', 's'};
        keyboard[8] = new char[]{'t','u','v'};
        keyboard[9] = new char[]{'w','x','y', 'z'};
    }
    public List<String> letterCombinations(String digits) {
        LinkedList<String> l = new LinkedList<>();
        if(digits.length() <= 0) return l;
        StringBuilder sb = new StringBuilder(digits.length());
        for (int i = 0; i < digits.length(); i++) {
            sb.append(" ");
        }

        letter(l, sb, digits, 0);

        return l;
    }

    // Recursive
    private void letter(List<String> l, StringBuilder sb, String digits, int idx){
        if(idx>=digits.length()){
            l.add(sb.toString().trim());
            return;
        }
        int digit = digits.charAt(idx) - 0x30;
        if(digit == 1){
            letter(l, sb, digits, idx+1);
        }else{
            char[] chars = keyboard[digit];
            for (int i = 0; i < chars.length; i++) {
                sb.setCharAt(idx, chars[i]);
                letter(l, sb, digits, idx+1);
            }
        }
    }
}
```