class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;
        
        java.util.HashMap<Long, Integer> cnt = new java.util.HashMap<>();
        for (int[] p : points) {
            long y = p[1];
            cnt.put(y, cnt.getOrDefault(y, 0) + 1);
        }
        
        long sumT = 0L;
        long sumSquares = 0L;
        for (int c : cnt.values()) {
            if (c < 2) continue;
            long t = ( (long)c * (c - 1) / 2 ) % MOD;
            sumT = (sumT + t) % MOD;
            sumSquares = (sumSquares + (t * t) % MOD) % MOD;
        }
        long ans = ( ( (sumT * sumT) % MOD - sumSquares ) % MOD + MOD ) % MOD;
        
        long inv2 = (MOD + 1) / 2; 
        ans = (ans * inv2) % MOD;
        return (int) ans;
    }
}
