class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stations[i];

        // compute initial power[i]
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        long low = 0, high = prefix[n] + k, ans = 0;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // diff-array approach: diff[end] -= need to expire contribution after end-1
    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1]; // allow diff[n] writes safely
        long cur = 0; // current added stations affecting index i

        for (int i = 0; i < n; i++) {
            cur += diff[i]; // apply scheduled expirations/additions at i
            long currPower = power[i] + cur;
            if (currPower < target) {
                long need = target - currPower;
                k -= need;
                if (k < 0) return false;
                // place the added stations at pos = min(n-1, i + r)
                int pos = Math.min(n - 1, i + r);
                // they immediately affect current city i
                cur += need;
                // schedule expiration at pos + r + 1 (if inside array)
                int end = pos + r + 1;
                if (end < n) diff[end] -= need;
            }
        }
        return true;
    }
}
