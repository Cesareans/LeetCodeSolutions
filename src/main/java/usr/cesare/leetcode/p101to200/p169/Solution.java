package usr.cesare.leetcode.p101to200.p169;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                candidate = nums[i];
            }
            count += (nums[i] == candidate)?1:-1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{
                1,1,1,2,3,1,1,2,2,2,2,2,2,
        }));
        System.out.println(new Solution().majorityElement(new int[]{
                1,1,1,1
        }));
    }
}
