class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] freq = new int[100001];
        long total = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            total += diff;
        }

        if (k >= total) {
            return 0;
        }

        for (int d = 100000; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            int count = freq[d];
            int reduce = (int) Math.min(k, (long) count);

            freq[d] -= reduce;
            freq[d - 1] += reduce;
            k -= reduce;
        }

        long ans = 0;

        for (int d = 1; d <= 100000; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}