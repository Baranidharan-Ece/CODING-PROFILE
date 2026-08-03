class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) 
        sum += b;

        long low = 0, high = sum / n;

        while (low < high) {
            long mid = high - (high - low) / 2;

            if (canRun(n, batteries, mid)) {
                low = mid;     
            } else {
                high = mid - 1; 
            }
        }

        return low;
    }

    private boolean canRun(int n, int[] batteries, long time) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
        }
        return total >= time * n;
    }
}
