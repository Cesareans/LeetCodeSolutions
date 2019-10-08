# LeetCode Solution P1-Two Sum
哈希索引：
    
    借助哈希表，可一次遍历解析，实现简单。假设哈希效率高，单次查找为O(1)，则时间复杂度可视为O(n)，空间复杂度O(n)

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; ++i){
            int theOther = target - nums[i];
            if(intMap.containsKey(theOther))
                return new int[]{i, intMap.get(theOther)};
            intMap.put(nums[i], i);
        }
        return null;
    }
}
```