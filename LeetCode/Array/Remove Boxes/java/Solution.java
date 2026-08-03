class Solution {
    int[][][] dp;
    int[] colors, counts;
    int total;

    public int removeBoxes(int[] boxes) {
       
        List<Integer> c = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        for (int b : boxes) {
            if (!c.isEmpty() && c.get(c.size() - 1) == b)
                cnt.set(cnt.size() - 1, cnt.get(cnt.size() - 1) + 1);
            else {
                c.add(b);
                cnt.add(1);
            }
        }

        int n = c.size();
        colors = new int[n];
        counts = new int[n];
        total = boxes.length;

        for (int i = 0; i < n; i++) {
            colors[i] = c.get(i);
            counts[i] = cnt.get(i);
        }

        
        dp = new int[n][n][total + 1];

        return dfs(0, n - 1, 0);
    }

    private int dfs(int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];

        
        int res = dfs(l, r - 1, 0) + (counts[r] + k) * (counts[r] + k);

        
        for (int i = l; i < r; i++) {
            if (colors[i] == colors[r]) {
                res = Math.max(res,
                    dfs(l, i, k + counts[r]) + dfs(i + 1, r - 1, 0)
                );
            }
        }

        return dp[l][r][k] = res;
    }
}
