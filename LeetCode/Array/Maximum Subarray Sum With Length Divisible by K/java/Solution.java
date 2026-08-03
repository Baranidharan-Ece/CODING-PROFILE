class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        long[] minPref = new long[k];
        boolean[] seen = new boolean[k];

        long ans = Long.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int mod = i % k;

            if (seen[mod]) {
                ans = Math.max(ans, pref[i] - minPref[mod]);
            }

            if (!seen[mod] || pref[i] < minPref[mod]) {
                minPref[mod] = pref[i];
                seen[mod] = true;
            }
        }

        return ans;
    }
}
