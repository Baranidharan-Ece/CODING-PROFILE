class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        int max = 100000 * 2;
        long[] left = new long[max + 1];
        long[] right = new long[max + 1];

        
        for (int x : nums)
         right[x]++;

        long ans = 0;

        for (int j = 0; j < n; j++) {
            int mid = nums[j];
            right[mid]--;  

            int target = mid * 2;
            if (target <= max) {
                ans = (ans + left[target] * right[target]) % MOD;
            }

            left[mid]++;  
        }

        return (int) ans;
    }
}
