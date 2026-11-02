// AI-assisted archived practice solution.
class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = 46340;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid;
            if (square == num) return true;
            if (square < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
