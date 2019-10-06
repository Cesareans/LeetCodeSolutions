package usr.cesare.leetcode.p101to200.p119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rl = new ArrayList<>(rowIndex);
        rl.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            int pre = 1;
            for (int j = 1; j < rl.size(); ++j) {
                rl.set(j, pre + (pre = rl.get(j)));
            }
            rl.add(1);
        }
        return rl;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(0));
        System.out.println(new Solution().getRow(1));
        System.out.println(new Solution().getRow(2));
        System.out.println(new Solution().getRow(3));
        System.out.println(new Solution().getRow(4));
    }
}
