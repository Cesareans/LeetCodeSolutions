package usr.cesare.leetcode.p1to100.p69;

class Solution {
    public int mySqrt(int x) {
        return (int)mySqrt(x, 0, x);
    }
    private long mySqrt(long x, long l, long r) {
        if (l == r) return l;
        long mid = (l + r) / 2;
        if (mid * mid == x) {
            return mid;
        }
        if (mid * mid < x) {
            if ((mid + 1) * (mid + 1) > x) {
                return mid;
            }
            return mySqrt(x, mid + 1, r);
        } else {
            if ((mid - 1) * (mid - 1) < x) {
                return mid - 1;
            }
            return mySqrt(x, l, mid - 1);
        }
    }
}

class Solution1{
    public int mySqrt(float x)
    {
        final float precision = 0.1f;
        float res = x, pre;
        do
        {
            pre = res;
            res = (res + x/res) / 2;
        }while(Math.abs(res-pre) > precision);
        return (int)res;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(new Solution1().mySqrt(0));
        System.out.println(new Solution1().mySqrt(1));
        System.out.println(new Solution1().mySqrt(2));
        System.out.println(new Solution1().mySqrt(3));
        System.out.println(new Solution1().mySqrt(4));
        System.out.println(new Solution1().mySqrt(8));
        System.out.println(new Solution1().mySqrt(9));
        System.out.println(new Solution1().mySqrt(10));
        System.out.println(new Solution().mySqrt(2147395600));
        System.out.println(new Solution1().mySqrt(2147395599));
    }
}
