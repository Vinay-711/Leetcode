// AI-assisted archived practice solution.
class Solution {
    public int mySqrt(int x) {
        int lo = 0, hi = 46341;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long) mid * mid <= x) lo = mid + 1;
            else hi = mid;
        }
        return lo - 1;
    }
}
