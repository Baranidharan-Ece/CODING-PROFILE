class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    
        if (desiredTotal <= 0) return true;
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) return false;

        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(0, maxChoosableInteger, desiredTotal, memo);
    }

    private boolean canWin(int used, int maxInt, int target, Map<Integer, Boolean> memo) {
        if (memo.containsKey(used)) return memo.get(used);

        for (int i = 1; i <= maxInt; i++) {
            int bit = 1 << (i - 1);
            if ((used & bit) == 0) { // if i is not used
                
                if (i >= target || !canWin(used | bit, maxInt, target - i, memo)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }

        memo.put(used, false);
        return false;
    }
}
