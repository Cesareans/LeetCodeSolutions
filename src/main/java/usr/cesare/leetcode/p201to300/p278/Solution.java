package usr.cesare.leetcode.p201to300.p278;
class VersionControl{
    protected boolean isBadVersion(int v){
        return false;
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid;
        while(l < r){
            mid = l + (r-l)/2;
            if(isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
