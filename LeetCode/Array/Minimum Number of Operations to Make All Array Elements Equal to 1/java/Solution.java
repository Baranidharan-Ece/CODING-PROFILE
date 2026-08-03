import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int overallGcd = nums[0];

        // Step 1: GCD of all elements
        for (int i = 1; i < n; i++) {
            overallGcd = gcd(overallGcd, nums[i]);
        }

        // If GCD of all elements > 1, impossible
        if (overallGcd > 1) return -1;

        // Step 2: If any 1 exists
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) return n - ones;

        // Step 3: Find shortest subarray with GCD = 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currGcd = nums[i];
            for (int j = i; j < n; j++) {
                currGcd = gcd(currGcd, nums[j]);
                if (currGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // No need to extend further
                }
            }
        }

        // Step 4: (minLen - 1) + (n - 1)
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
