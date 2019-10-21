package usr.cesare.leetcode.p1to100.p33;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (nums[mid] == target) return mid;
        else if(l >= r) return -1;
        if (nums[mid] > nums[l]) {
            if (target <= nums[mid] && target >= nums[l]) {
                return search(nums, target, l, mid);
            }else{
                return search(nums, target, mid + 1, r);
            }
        }else if(nums[mid] < nums[r]) {
            if (target >= nums[mid] && target <= nums[r]) {
                return search(nums, target, mid, r);
            }else{
                return search(nums, target, l, mid - 1);
            }
        }else{
            return -1;
        }
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{3,4,5,1,2}, 2));
    }
}
