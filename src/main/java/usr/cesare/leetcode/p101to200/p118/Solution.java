package usr.cesare.leetcode.p101to200.p118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> resultList = new ArrayList<>(numRows);
        if(numRows == 0) return resultList;
        resultList.add(new ArrayList<>(Collections.singletonList(1)));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> preList = resultList.get(i-1);
            ArrayList<Integer> rowList = new ArrayList<>(i);
            rowList.add(1);
            for (int j = 1; j < i; ++j) {
                rowList.add(preList.get(j-1)+preList.get(j));
            }
            rowList.add(1);
            resultList.add(rowList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(0));
        System.out.println(new Solution().generate(1));
        System.out.println(new Solution().generate(5));
    }
}
