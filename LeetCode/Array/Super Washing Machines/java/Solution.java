class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) total += m;
        
        int n = machines.length;
        if (total % n != 0) return -1;
        
        int avg = total / n;
        int res = 0, transfer = 0;
        
        for (int load : machines) {
            int diff = load - avg;
            transfer += diff; 
            res = Math.max(res, Math.max(Math.abs(transfer), diff));
        }
        
        return res;
    }
}
