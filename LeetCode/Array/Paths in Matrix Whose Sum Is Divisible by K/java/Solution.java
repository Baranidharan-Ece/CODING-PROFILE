class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        final int MOD = 1_000_000_007;

       
        int[][] dp = new int[n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int[] top = dp[j];
                
                int[] left = (j > 0) ? dp[j - 1] : null;

                int[] cur = new int[k];

                for (int r = 0; r < k; r++) {
                    long ways = 0L;
                    
                    ways += top[r];
                   
                    if (left != null) ways += left[r];
              
                    if (i == 0 && j == 0 && r == 0) ways += 1;

                    if (ways == 0) continue;
                    int newR = (r + grid[i][j]) % k;
                    cur[newR] = (int)((cur[newR] + ways) % MOD);
                }

   
                dp[j] = cur;
            }
        }

        return dp[n - 1][0];
    }
}
