# LeetCode Solution P11-Container With Most Water
双向双指针解法：

    该题对于最终答案的求解，因为其最优解的值仅决定于左右两根柱子的位置以及其中最短的柱子的长度，所以使用双指针。
    考虑到如果我们两个指针均正向移动，则实际上时间复杂度依然为O(n^2)，同时因为仅考虑最短柱子的长度，故可考虑两个指针向对方移动，同时仅移动最短的那根指针
    
代码：
```
public class Solution {
    public int maxArea(int[] height) {
        int l, r, m = 0;
        for (l = 0, r = height.length - 1; l < r; ) {
            m = Math.max(m, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return m;
    }
}
```
    