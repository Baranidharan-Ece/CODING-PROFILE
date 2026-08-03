class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        return helper(a % MOD, b, b.length - 1);
    }
    
    private int helper(int a, int[] b, int idx) {
        if (idx < 0) return 1;
        
        int part1 = powMod(a, b[idx]);           // a^(last digit)
        int part2 = powMod(helper(a, b, idx - 1), 10);  // (previous result)^10
        
        return (part1 * part2) % MOD;
    }
    
    private int powMod(int a, int k) {
        int res = 1;
        a %= MOD;
        for (int i = 0; i < k; i++) {
            res = (res * a) % MOD;
        }
        return res;
    }
}
