class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) xor ^= n;

        // Get rightmost set bit
        int diff = xor & -xor;

        int x = 0, y = 0;
        for (int n : nums) {
            if ((n & diff) == 0) x ^= n;  
            else y ^= n;                  
        }

        return new int[]{x, y};
    }
}
